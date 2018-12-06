import {Component, OnDestroy, OnInit, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {UserService} from "../../../connect/user/user.service";
import {Account} from "../../../model/account";
import {GroupService} from "../../../connect/group/group.service";
import {Group} from "../../../model/group";
import {Role} from "../../../model/role";
import {AccountToStudentPipe} from "../../../util/pipe/account-to-student/account-to-student.pipe";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit,OnDestroy {


  public editMode: boolean = false;
  public roleTypes: Role[];
  public groupId: number;
  public groups: Group[];
  public accounts: Account[];
  public accountToEdit: Account = new Account();
  public modalEditor: BsModalRef;
  private subscriptions: Subscription[] = [];
  public roleId: number;
  totalElements = 0;
  pageNumber: number = 1;
  elementsToView: number = 25;
  lastNameSearchParam: string = "";


  constructor(private accountService: UserService,
              private groupService: GroupService,
              private accountToStudentPipe: AccountToStudentPipe,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) {

  }

  ngOnInit() {
    this._loadPage();
    this._updateNumberOfEntries();
    this._loadRoles();
  }


  public _closeModal(): void {
    this.modalEditor.hide();
  }

  public _openModal(template: TemplateRef<any>, account?: Account): void {

    if (account) {
      this.editMode = true;
      this.accountToEdit = Account.clone(account);
    } else {
      this._refreshAccountToEdit();
      this.editMode = false;
    }

    this.modalEditor = this.modalService.show(template);
  }


  public _addStudent(): void {
    this.loadingService.show();
    this.subscriptions.push(this.accountService.saveStudent(
      this.accountToStudentPipe.transform(this.accountToEdit, this.groupId)).subscribe(() => {
      this._updateAccounts();
      this._updateNumberOfEntries();
      this._refreshAccountToEdit();
      this._closeModal();
      this.loadingService.hide();
    }));
  }

  public _addAccount(): void {
    this.loadingService.show();
    this.subscriptions.push(this.accountService.saveAccount(this.accountToEdit).subscribe(() => {
      this._updateAccounts();
      this._updateNumberOfEntries();
      this._refreshAccountToEdit();
      this._closeModal();
      this.loadingService.hide();
    }));

  }

  public _updateAccounts(): void {
    this._loadPage();
  }

  public _deleteAccount(id: number): void {
    this.loadingService.show();
    this.subscriptions.push(this.accountService.deleteAccount(id).subscribe(() => {
      this._updateAccounts();
      this._updateNumberOfEntries();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  private _refreshAccountToEdit(): void {
    this.accountToEdit = new Account();
  }


  private _loadPage(): void {
    this.loadingService.show();
    this.subscriptions.push(this.accountService.getAll(this.pageNumber - 1, this.elementsToView).subscribe(accounts => {
      this.accounts = accounts;
      this.loadingService.hide();
    }));
  }

  private _updateNumberOfEntries(): void {
    this.subscriptions.push(this.accountService.count().subscribe(numberOfEntries => {
      this.totalElements = numberOfEntries;
    }));
  }

  private _loadRoles(): void {
    this.loadingService.show();
    this.subscriptions.push(this.accountService.getRoles().subscribe(roles => {
      this.roleTypes = roles;
      this.loadingService.hide();
    }));
  }

  _search() {
    this.loadingService.show();
    this.subscriptions.push(
      this.roleId ? this.accountService.findByLastNameAndRole(this.lastNameSearchParam, this.roleId).subscribe(accounts => {
          this.accounts = accounts;
          this.loadingService.hide();
        }) :
        this.accountService.findByLastName(this.lastNameSearchParam).subscribe(accounts => {
          this.accounts = accounts;
          this.loadingService.hide();
        }));

  }

  ifStudent(role: Role): boolean {
    return role && role.name == 'Student';
  }

  _elasticSearchGroups(event) {
    if ((event + '').match('[0-9]+')) {
      this.subscriptions.push(this.groupService.getGroupsByParam('number', event).subscribe(groups => {
        this.groups = groups;
      }));
    }
  }
}
