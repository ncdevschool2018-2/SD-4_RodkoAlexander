import {Component, OnInit, TemplateRef} from '@angular/core';
import {Lesson} from "../../../model/lesson";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Group} from "../../../model/group";
import {ScheduleService} from "../../../connect/schedule/schedule.service";
import {GroupService} from "../../../connect/group/group.service";
import {UserService} from "../../../connect/user/user.service";
import {User} from "../../../model/user";

@Component({
  selector: 'app-lesson',
  templateUrl: './lesson.component.html',
  styleUrls: ['./lesson.component.css']
})
export class LessonComponent implements OnInit {

  public editMode = false;
  public selectedItems = [];
  public dropdownSettings = {};
  public lessonTypes = ['Laboratory', 'Practical', 'Lection'];
  public lessons: Lesson[] = [];
  public teachers: User[] = [];
  public groups: Group[] = [];
  public lessonToEdit: Lesson = new Lesson();
  public modalEditor: BsModalRef;
  private subscriptions: Subscription[] = [];

  constructor(private scheduleService: ScheduleService,
              private groupService: GroupService,
              private userService: UserService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) {

  }

  multiSelectInit() {
    this.selectedItems = [];
    this.dropdownSettings = {
      singleSelection: false,
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      allowSearchFilter: true,
    };
  }

  ngOnInit() {
    this.loadGroups();
    this.loadLessons();
    this.loadTeachers();
    this.multiSelectInit();
  }


  public _closeModal(): void {
    this.modalEditor.hide();
  }

  public _openModal(template: TemplateRef<any>, lesson: Lesson): void {

    if (lesson) {
      this.editMode = true;
      this.lessonToEdit = Lesson.clone(lesson);
    } else {
      this.refreshLessonToEdit();
      this.editMode = false;
    }

    this.modalEditor = this.modalService.show(template);
  }

  public _addLesson(): void {
    this.subscriptions.push(this.scheduleService.saveLesson(this.lessonToEdit).subscribe(() => {
      this._updateLessons();
      this.refreshLessonToEdit();
      this._closeModal();

    }));


  }

  public _updateLessons(): void {
    this.loadLessons();
  }

  public _deleteLesson(id: number): void {
    this.loadingService.show();
    this.subscriptions.push(this.scheduleService.deleteLesson(id).subscribe(() => {
      this._updateLessons();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  private refreshLessonToEdit(): void {
    this.lessonToEdit = new Lesson();
  }

  private loadLessons(): void {
    this.loadingService.show();
    this.subscriptions.push(this.scheduleService.getLessons().subscribe(lessons => {
      this.lessons = lessons;
      this.loadingService.hide();
    }));
  }


  private loadGroups() {
    this.loadingService.show();
    this.subscriptions.push(this.groupService.getGroups().subscribe(gr => {
      this.groups = gr;
      this.loadingService.hide();
    }));
  }

  private loadTeachers() {
    this.loadingService.show();
    this.subscriptions.push(this.userService.getTeachers().subscribe(teachers => {
      console.log(this.teachers);
      this.teachers = teachers;
      this.loadingService.hide();
    }));
  }

}
