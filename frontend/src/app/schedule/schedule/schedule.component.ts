import {Component, OnInit, TemplateRef} from "@angular/core";
import {Subscription} from "rxjs";
import {ScheduleService} from "../../connect/schedule/schedule.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Lesson} from "../../model/lesson";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {VisitService} from "../../connect/visit/visit.service";
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {
  public editMode = false;
  public lessons: Lesson[] = [];
  public week: number = 604800000;
  private pipe: DatePipe = new DatePipe('en-US');
  public dateToLoadFrom: Date;
  public dateToLoadTo: Date;
  public selectedType: string;
  public scheduleTypes: string[] = ['Teacher', 'Student'];
  public lessonToEdit: Lesson = new Lesson();
  public modalEditor: BsModalRef;
  private subscriptions: Subscription[] = [];
  searchId: string;

  constructor(private scheduleService: ScheduleService,
              private visitService: VisitService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) {

  }

  ngOnInit() {
    this._now();

  }


  public _closeModal(): void {
    this.modalEditor.hide();
  }

  public _openModal(template: TemplateRef<any>, lesson: Lesson): void {

    if (lesson) {
      this.editMode = true;
      this.lessonToEdit = Lesson.clone(lesson);
    } else {
      this._refreshLessonToEdit();
      this.editMode = false;
    }

    this.modalEditor = this.modalService.show(template);
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  private _refreshLessonToEdit(): void {
    this.lessonToEdit = new Lesson();
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

  _now() {
    this.dateToLoadFrom = new Date();
    this.dateToLoadTo = new Date(this.dateToLoadFrom.getTime() + (this.week));
  }

  _changeWeek(weekChange: number) {
    this.dateToLoadTo.setTime(this.dateToLoadTo.getTime() + (weekChange * this.week));
    this.dateToLoadFrom.setTime(this.dateToLoadFrom.getTime() + (weekChange * this.week));
    this._search();
  }

  _search() {
    this.selectedType == 'Student' ? this._loadStudentLessons() : this._loadTeacherLessons();
  }

  _searchNow() {
    this._now();
    this._search();
  }
}
