import {Component, OnInit, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {UserService} from "../../../connect/user/user.service";
import {Account} from "../../../model/account";
import {GroupService} from "../../../connect/group/group.service";
import {Group} from "../../../model/group";
import {AccountToStudentPipe} from "../../pipe/account-to-student/account-to-student.pipe";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {


  public editMode: boolean = false;
  public roleTypes: string[] = ["Teacher", "Student", "Administrator"];
  public groupId: number;
  public groups: Group[];
  public accounts: Account[];
  public accountToEdit: Account = new Account();
  public modalEditor: BsModalRef;
  private subscriptions: Subscription[] = [];


  constructor(private accountService: UserService,
              private groupService: GroupService,
              private accountToStudentPipe: AccountToStudentPipe,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) {

  }

  ngOnInit() {
    this.loadAccounts();
    this.loadGroups();
  }


  public _closeModal(): void {
    this.modalEditor.hide();
  }

  public _openModal(template: TemplateRef<any>, account?: Account): void {

    if (account) {
      this.editMode = true;
      this.accountToEdit = Account.clone(account);
    } else {
      this.refreshAccountToEdit();
      this.editMode = false;
    }

    this.modalEditor = this.modalService.show(template);
  }

  public _addAccount(): void {
    this.loadingService.show();
    if (this.accountToEdit.role == "Student") {
      this.subscriptions.push(this.accountService.saveStudent(
        this.accountToStudentPipe.transform(this.accountToEdit, this.groupId)).subscribe(() => {
        this._updateAccounts();
        this.refreshAccountToEdit();
        this._closeModal();
        this.loadingService.hide();
      }));
    } else {
      this.subscriptions.push(this.accountService.saveAccount(this.accountToEdit).subscribe(() => {
        this._updateAccounts();
        this.refreshAccountToEdit();
        this._closeModal();
        this.loadingService.hide();
      }));
    }
  }

  public _updateAccounts(): void {
    this.loadAccounts();
  }

  public _deleteAccount(id: number): void {
    this.loadingService.show();
    this.subscriptions.push(this.accountService.deleteAccount(id).subscribe(() => {
      this._updateAccounts();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  private refreshAccountToEdit(): void {
    this.accountToEdit = new Account();
  }

  private loadAccounts(): void {
    this.loadingService.show();
    this.subscriptions.push(this.accountService.getAccounts().subscribe(accounts => {
      this.accounts = accounts;
      this.loadingService.hide();
    }));
  }

  private loadGroups(): void {
    this.loadingService.show();
    this.subscriptions.push(this.groupService.getGroups().subscribe(groups => {
      this.groups = groups;
      this.loadingService.hide();
    }));
  }
}
