import {Component, OnInit, TemplateRef} from '@angular/core';
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
export class GroupComponent implements OnInit {

  public editMode = false;

  public groups: Group[];
  public groupToEdit: Group = new Group();
  public groupStudents: User[];
  public modalEditor: BsModalRef;
  private subscriptions: Subscription[] = [];


  constructor(private groupService: GroupService,
              private userService: UserService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) {

  }

  ngOnInit() {
    this.loadGroups();
  }


  public _closeModal(): void {
    this.modalEditor.hide();
  }

  public _openModal(template: TemplateRef<any>, group: Group): void {

    if (group) {
      this.editMode = true;
      this.groupToEdit = Group.clone(group);
    } else {
      this.refreshGroupToEdit();
      this.editMode = false;
    }

    this.modalEditor = this.modalService.show(template);
  }

  public _addGroup(): void {
    this.loadingService.show();
    this.subscriptions.push(this.groupService.saveGroup(this.groupToEdit).subscribe(() => {
      this._updateGroups();
      this.refreshGroupToEdit();
      this._closeModal();
      this.loadingService.hide();

    }));
  }

  public _updateGroups(): void {
    this.loadGroups();
  }

  public _deleteGroup(id: number): void {
    this.loadingService.show();
    this.subscriptions.push(this.groupService.deleteGroup(id).subscribe(() => {
      this._updateGroups();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  private refreshGroupToEdit(): void {
    this.groupToEdit = new Group();
  }

  private loadGroups(): void {
    this.loadingService.show();
    this.subscriptions.push(this.groupService.getGroups().subscribe(groups => {
      this.groups = groups;
      this.loadingService.hide();
    }));
  }

  private loadStudentsFromGroup(groupId: number): void {
    this.loadingService.show();
    this.subscriptions.push(this.userService.getStudentsFromGroup(groupId).subscribe(students => {
      console.log(this.groupStudents);
      this.groupStudents = students;
      this.loadingService.hide();
    }));
  }

  public _students(template: TemplateRef<any>,groupId :number): void {
    this.loadStudentsFromGroup(groupId);
    this.modalEditor = this.modalService.show(template);
  }
}
