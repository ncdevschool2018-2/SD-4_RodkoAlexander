import {Component, OnDestroy, OnInit, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Group} from "../../../model/group";
import {GroupService} from "../../../connect/group/group.service";
import {User} from "../../../model/user";
import {UserService} from "../../../connect/user/user.service";

@Component({
  selector: 'app-group',
  templateUrl: './group.component.html',
  styleUrls: ['./group.component.css']
})
export class GroupComponent implements OnInit,OnDestroy {

  public editMode = false;

  public groups: Group[];
  public groupToEdit: Group = new Group();
  public groupStudents: User[];
  public modalEditor: BsModalRef;
  private subscriptions: Subscription[] = [];
  totalElements = 100;
  pageNumber: number = 1;
  elementsToView: number = 25;
  searchParam: string = '';
  searchValue: string = '';
  findParams: string[] = ['course', 'number'];


  constructor(private groupService: GroupService,
              private userService: UserService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) {

  }

  ngOnInit() {
    this._loadPage();
    this._updateNumberOfEntries();
  }


  public _closeModal(): void {
    this.modalEditor.hide();
  }

  public _openModal(template: TemplateRef<any>, group: Group): void {

    if (group) {
      this.editMode = true;
      this.groupToEdit = Group.clone(group);
    } else {
      this._refreshGroupToEdit();
      this.editMode = false;
    }

    this.modalEditor = this.modalService.show(template);
  }

  public _addGroup(): void {
    this.loadingService.show();
    this.subscriptions.push(this.groupService.saveGroup(this.groupToEdit).subscribe(() => {
      this._updateGroups();
      this._updateNumberOfEntries();
      this._refreshGroupToEdit();
      this._closeModal();
      this.loadingService.hide();

    }));
  }

  public _updateGroups(): void {
    this._loadPage();
  }

  public _deleteGroup(id: number): void {
    this.loadingService.show();
    this.subscriptions.push(this.groupService.deleteGroup(id).subscribe(() => {
      this._updateGroups();
      this._updateNumberOfEntries();
      this.loadingService.hide();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  private _refreshGroupToEdit(): void {
    this.groupToEdit = new Group();
  }

  private _loadStudentsFromGroup(groupId: number): void {
    this.loadingService.show();
    this.subscriptions.push(this.userService.getStudentsFromGroup(groupId).subscribe(students => {
      this.groupStudents = students;
      this.loadingService.hide();
    }));
  }

  private _loadPage(): void {
    this.loadingService.show();
    this.subscriptions.push(this.groupService.getGroups(this.pageNumber - 1,this.elementsToView).subscribe(groups => {
      this.groups = groups;
      this.loadingService.hide();
    }));
  }

  public _students(template: TemplateRef<any>,groupId :number): void {
    this._loadStudentsFromGroup(groupId);
    this.modalEditor = this.modalService.show(template);
  }

  private _updateNumberOfEntries(): void {
    this.subscriptions.push(this.groupService.count().subscribe(numberOfEntries => {
      this.totalElements = numberOfEntries;
    }));
  }

  _search() {
    this.loadingService.show();
    this.subscriptions.push(
      this.groupService.getGroupsByParam(this.searchParam, +this.searchValue).subscribe(groups => {
          this.groups = groups;
          this.loadingService.hide();
        }));

  }
}
