import {Component, OnInit, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Account} from "../../model/account";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {AccountService} from "../../connect/account/account.service";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  public editMode = false;

  public accounts: Account[];
  public accountToEdit: Account = new Account();
  public modalEditor: BsModalRef;
  public roleTypes = ['Admin','Teacher','Student'];
  private subscriptions: Subscription[] = [];


  constructor(private accountService: AccountService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) {

  }

  ngOnInit() {
    this.loadAccounts();
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

  public _deleteAccount(accountId: string): void {
    this.loadingService.show();
    this.subscriptions.push(this.accountService.deleteAccount(accountId).subscribe(() => {
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
}
