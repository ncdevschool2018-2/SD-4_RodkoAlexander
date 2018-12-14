import {Component, OnInit, TemplateRef} from "@angular/core";
import {Subscription} from "rxjs";
import {ScheduleService} from "../../connect/schedule/schedule.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Lesson} from "../../model/lesson";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {VisitService} from "../../connect/visit/visit.service";
import {DatePipe} from "@angular/common";
import {Visit} from "../../model/visit";
import {UserService} from "../../connect/user/user.service";
import {StudentsToVisitsPipe} from "../../util/pipe/students-to-visits/students-to-visits.pipe";
import {TokenProcessorService} from "../../util/pipe/token-processor.service";

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {
  public editMode = false;
  public lessons: Lesson[] = [];
  private visitsPipe: StudentsToVisitsPipe = new StudentsToVisitsPipe();
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
  public visitsForGroup: Visit[] = [];

  constructor(private scheduleService: ScheduleService,
              private visitService: VisitService,
              private userService: UserService,
              private loadingService: Ng4LoadingSpinnerService,
              private tokenProcessor: TokenProcessorService,
              private modalService: BsModalService) {

  }

  ngOnInit() {
    this._now();

  }


  isEmployer(): boolean {
    return this.tokenProcessor.isTeacher(sessionStorage.getItem("Token")) || this.tokenProcessor.isAdmin(sessionStorage.getItem("Token"));
  }

  public _closeModal(): void {
    this.modalEditor.hide();
  }

  public _openModal(template: TemplateRef<any>, lesson: Lesson): void {

    if (lesson) {
      this.editMode = true;
      this.lessonToEdit = Lesson.clone(lesson);
      console.log(this.lessonToEdit)
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


  _loadVisits(groupId: number, lessonId: number): void {
    this.visitsForGroup = [];
    this.loadingService.show();
    this.subscriptions.push(this.visitService.getVisits(lessonId, groupId).subscribe(groupVisits => {
      this.loadingService.show();
      if (groupVisits.length > 0)
        this.visitsForGroup = groupVisits;
      this.loadingService.hide();
    }));
    if (this.visitsForGroup.length > 0) {
      this.subscriptions.push(this.userService.getStudentsFromGroup(groupId).subscribe(ifNotProtocoled => {
        this.loadingService.show();
        this.visitsForGroup = this.visitsPipe.transform(ifNotProtocoled, this.lessonToEdit);
        this.loadingService.hide();
      }));
    }
  }

  _saveVisits() {
    this.loadingService.show();
    this.subscriptions.push(this.visitService.saveVisits(this.visitsForGroup).subscribe(() => {
      this.loadingService.hide();
    }));
  }
}
