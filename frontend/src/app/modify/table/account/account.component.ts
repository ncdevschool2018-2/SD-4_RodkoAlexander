import {Component, OnInit, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {AccountService} from "../../../connect/account/account.service";
import {Account} from "../../../model/account";
import {GroupService} from "../../../connect/group/group.service";
import {Group} from "../../../model/group";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {


  public editMode = false;
  public roleTypes: string[] = ["Teacher", "Student", "Administrator"];
  public groups: Group[];
  public accounts: Account[];
  public accountToEdit: Account = new Account();
  public modalEditor: BsModalRef;
  private subscriptions: Subscription[] = [];


  constructor(private accountService: AccountService,
              private groupService: GroupService,
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

  public _openModal(template: TemplateRef<any>, account: Account): void {

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
    console.log(this.accountToEdit);
    if (this.accountToEdit.user.role != "Student") {
      this.accountToEdit.user.groupNumber = null;
    }
    this.subscriptions.push(this.accountService.saveAccount(this.accountToEdit).subscribe(() => {
      this._updateAccounts();
      this.refreshAccountToEdit();
      this._closeModal();
      this.loadingService.hide();

    }));
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
    this.subscriptions.push(this.groupService.getDescriptions().subscribe(groups => {
      this.groups = groups;
      this.loadingService.hide();
    }));
  }
}
