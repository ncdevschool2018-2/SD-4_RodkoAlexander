import {Component, OnInit, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Account} from "../../../model/account";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {AccountService} from "../../../connect/account/account.service";
import {GroupService} from "../../../connect/group/group.service";
import {Group} from "../../../model/group";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  public editMode = false;

  public accounts: Account[];
  public accountToEdit: Account = new Account();
  public groupForStudent: Group;
  public groups: Group[];
  public modalEditor: BsModalRef;
  public roleTypes = ['Admin', 'Teacher', 'Student'];
  private subscriptions: Subscription[] = [];


  constructor(private accountService: AccountService,
              private groupService: GroupService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) {

  }

  ngOnInit() {
    this.loadingService.show();
    this._loadAccounts();
    this._loadGroups();
    this.loadingService.hide();
  }


  public _closeModal(): void {
    this.modalEditor.hide();
  }

  public _openModal(template: TemplateRef<any>, account: Account): void {

    if (account) {
      this.editMode = true;
      this.accountToEdit = Account.clone(account);
    } else {
      this._refreshAccountToEdit();
      this.editMode = false;
    }

    this.modalEditor = this.modalService.show(template);
  }

  public _addAccount(): void {
    this.loadingService.show();
    this.accountToEdit.user.role == "Student" ? this._studentSave() : this._accountSave();

  }
  public _accountSave(){
    this.subscriptions.push(this.accountService.saveAccount(this.accountToEdit).subscribe(() => {
      this._updateAccounts();
      this._refreshAccountToEdit();
      this._closeModal();
      this.loadingService.hide();
    }));
  }

  public _updateAccounts(): void {
    this._loadAccounts();
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

  _studentSave() {
    this.groupForStudent.students = [];
    this.groupForStudent.students.push(this.accountToEdit);
    this.groupService.saveGroup(this.groupForStudent).subscribe(()=> {
      this._updateAccounts();
      this._refreshAccountToEdit();
      this._closeModal();
        this.loadingService.hide();
      }
    );
  }

  private _refreshAccountToEdit(): void {
    this.accountToEdit = new Account();
  }

  private _loadAccounts(): void {
    this.subscriptions.push(this.accountService.getAccounts().subscribe(accounts => {
      this.accounts = accounts;
    }));
  }

  private _loadGroups() {
    this.subscriptions.push(this.groupService.getDescriptions().subscribe(groups => {
      this.groups = groups;
    }));
  }
}
