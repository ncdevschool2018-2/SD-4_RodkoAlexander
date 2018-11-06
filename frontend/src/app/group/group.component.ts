import {Component, OnInit, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {GroupService} from "./service/group.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Group} from "../model/group";

@Component({
  selector: 'app-group',
  templateUrl: './group.component.html',
  styleUrls: ['./group.component.css']
})
export class GroupComponent implements OnInit {

  public editMode = false;

  public groups: Group[];
  public groupToEdit: Group = new Group();
  public modalEditor: BsModalRef;
  private subscriptions: Subscription[] = [];


  constructor(private groupService: GroupService,
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

  public _deleteGroup(groupId: string): void {
    this.loadingService.show();
    this.subscriptions.push(this.groupService.deleteGroup(groupId).subscribe(() => {
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

      this.groups = groups as Group[];

      console.log(this.groups);
      this.loadingService.hide();
    }));
  }
}
