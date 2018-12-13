import {ChangeDetectorRef, Component, OnDestroy, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Lesson} from "../../../model/lesson";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Group} from "../../../model/group";
import {ScheduleService} from "../../../connect/schedule/schedule.service";
import {GroupService} from "../../../connect/group/group.service";
import {UserService} from "../../../connect/user/user.service";
import {User} from "../../../model/user";
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-lesson',
  templateUrl: './lesson.component.html',
  styleUrls: ['./lesson.component.css']
})
export class LessonComponent implements OnInit ,OnDestroy{

  @ViewChild('teachers')
  private teachersBlock: TemplateRef<any>;

  public editMode = false;
  public selectedItems = [];
  public dropdownSettings = {};
  public lessonTypes = ['Laboratory', 'Practical', 'Lection'];
  public scheduleTypes: string[] = ['Teacher', 'Student'];
  public lessons: Lesson[] = [];
  public selectedTeacher: User[] = [];
  public teachers: User[] = [];
  public groups: Group[] = [];
  public lessonToEdit: Lesson = new Lesson();
  public modalEditor: BsModalRef;
  private subscriptions: Subscription[] = [];
  now: Date = new Date();
  totalElements = 0;
  pageNumber: number = 1;
  elementsToView: number = 25;
  searchId: string = '';
  public week: number = 604800000;
  private pipe: DatePipe = new DatePipe('en-US');
  public dateToLoadFrom: Date;
  public dateToLoadTo: Date;
  public selectedType: string;

  constructor(private scheduleService: ScheduleService,
              private groupService: GroupService,
              private userService: UserService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService,
              private cdr: ChangeDetectorRef) {

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
    this.loadPage();
    this._now();
    this.multiSelectInit();
    this._updateNumberOfEntries()
  }


  public _closeModal(): void {
    this.modalEditor.hide();
  }

  public _openModal(template: TemplateRef<any>, lesson: Lesson): void {

    if (lesson.id) {
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
      this._updateNumberOfEntries();
      this._closeModal();

    }));


  }

  public _updateLessons(): void {
    this.loadPage();
  }

  public _deleteLesson(id: number): void {
    this.loadingService.show();
    this.subscriptions.push(this.scheduleService.deleteLesson(id).subscribe(() => {
      this._updateLessons();
      this._updateNumberOfEntries();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  private refreshLessonToEdit(): void {
    this.lessonToEdit = new Lesson();
  }

  private loadPage(): void {
    this.loadingService.show();
    this.subscriptions.push(this.scheduleService.getLessons(this.pageNumber - 1, this.elementsToView).subscribe(lessons => {
      this.lessons = lessons;
      this.loadingService.hide();
    }));
  }

  _elasticSearchGroups(event) {
    if ((event + '').match('[0-9]+')) {
      this.subscriptions.push(this.groupService.getGroupsByParam('number', event).subscribe(groups => {
        this.groups = [];
        this.groups = [...this.groups, ...groups];
      }));
    }
  }

  _elasticSearchTeacher(event) {
    if ((event + '').match('[A-Z]{1}[a-z]+')) {
      this.userService.findUsersByLastNameAndRole(event,2).subscribe(data => {
        this.teachers = [];
        this.teachers = [...this.teachers,...data];
      });
    }
  }

  _updateNumberOfEntries(): void {
    this.subscriptions.push(this.scheduleService.count().subscribe(numberOfEntries => {
      this.totalElements = numberOfEntries;
    }));
  }

  _now() {
    this.dateToLoadFrom = new Date();
    this.dateToLoadTo = new Date(this.dateToLoadFrom.getTime() + (this.week));
  }

  _changeWeek(weekChange: number) {
    this.dateToLoadTo.setTime(this.dateToLoadTo.getTime() + (weekChange * this.week));
    this.dateToLoadFrom.setTime(this.dateToLoadFrom.getTime() + (weekChange * this.week));
    this._search();
  }

  private _loadTeacherLessons(): void {
    this.loadingService.show();
    this.subscriptions.push(this.scheduleService.getLessonsByTeacher(+this.searchId, this.pipe.transform(this.dateToLoadFrom, 'yyyy-MM-dd'),
      this.pipe.transform(this.dateToLoadTo, 'yyyy-MM-dd')).subscribe(lessons => {
      this.lessons = lessons;
      this.loadingService.hide();
    }));
  }

  private _loadStudentLessons(): void {
    this.loadingService.show();
    this.subscriptions.push(this.scheduleService.getLessonsByGroup(+this.searchId, this.pipe.transform(this.dateToLoadFrom, 'yyyy-MM-dd'),
      this.pipe.transform(this.dateToLoadTo, 'yyyy-MM-dd')).subscribe(lessons => {
      this.lessons = lessons;
      this.loadingService.hide();
    }));
  }

  _search() {
    this.selectedType == 'Student' ? this._loadStudentLessons() : this._loadTeacherLessons();
  }

  _searchNow() {
    this._now();
    this._search();
  }
}
