import {Component, OnInit, TemplateRef, ViewChild} from "@angular/core";
import {Subject, Subscription} from "rxjs";
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
import {CalendarEvent, CalendarEventAction, CalendarEventTimesChangedEvent, CalendarView} from "angular-calendar";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {
  addDays,
  addHours,
  endOfDay,
  endOfMonth, endOfWeek,
  isSameDay,
  isSameMonth,
  startOfDay,
  startOfISOWeek, startOfWeek,
  subDays
} from 'date-fns';
import {LessonsToCalendarEventsPipe} from "../../util/pipe/lessons-to-calendar-events/lessons-to-calendar-events.pipe";


const colors: any = {
  red: {
    primary: '#ff3131',
    secondary: '#FAE3E3'
  },
  blue: {
    primary: '#1e90ff',
    secondary: '#D1E8FF'
  },
  yellow: {
    primary: '#5eff00',
    secondary: '#bffdb4'
  }
};
@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {
  public editMode = false;
  public lessons: Lesson[] = [];
  private visitsPipe: StudentsToVisitsPipe = new StudentsToVisitsPipe();
  private lessonsToEventsPipe:LessonsToCalendarEventsPipe = new LessonsToCalendarEventsPipe();
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
              private modalService: BsModalService,
              private modal: NgbModal) {

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

  public _openModal(template: TemplateRef<any>, id: number): void {
    if (this.tokenProcessor.isAdmin(sessionStorage.getItem("Token"))||this.tokenProcessor.isTeacher(sessionStorage.getItem("Token"))) {
      let lesson: Lesson = this.findById(id);
      if (lesson) {
        this.editMode = true;
        this.lessonToEdit = Lesson.clone(lesson);
      } else {
        this._refreshLessonToEdit();
        this.editMode = false;
      }

      this.modalEditor = this.modalService.show(template);
    }
  }
  findById(id:number) :Lesson{
    for (let ls of this.lessons){
      if (ls.id === id){
        return ls;
      }
    }
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
      this.events = this.lessonsToEventsPipe.transform(this.lessons);
      this.loadingService.hide();
    }));
  }

  private _loadStudentLessons(): void {
    this.loadingService.show();
    this.subscriptions.push(this.scheduleService.getLessonsByGroup(+this.searchId, this.pipe.transform(this.dateToLoadFrom, 'yyyy-MM-dd'),
      this.pipe.transform(this.dateToLoadTo, 'yyyy-MM-dd')).subscribe(lessons => {
      this.lessons = lessons;
      this.events = this.lessonsToEventsPipe.transform(this.lessons);
      this.loadingService.hide();
    }));
  }

  _now() {
    this.dateToLoadFrom = startOfWeek(this.viewDate);
    this.dateToLoadTo = endOfWeek(this.viewDate);
  }

  _changeWeek() {
    this.dateToLoadTo = endOfWeek(this.viewDate);
    this.dateToLoadFrom = startOfWeek(this.viewDate);
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
    let needToGenerate: boolean = false;
    this.visitsForGroup = [];
    this.loadingService.show();
    this.subscriptions.push(this.visitService.getVisits(lessonId, groupId).subscribe(groupVisits => {
      this.loadingService.show();
      console.log(groupVisits.length);
      if (groupVisits.length > 0) {
        this.visitsForGroup = groupVisits;
      } else {
        this.subscriptions.push(this.userService.getStudentsFromGroup(groupId).subscribe(ifNotProtocoled => {
          this.loadingService.show();
          this.visitsForGroup = this.visitsPipe.transform(ifNotProtocoled, this.lessonToEdit);
          this.loadingService.hide();
        }));
      }
      this.loadingService.hide();
    }));

  }

  _saveVisits() {
    this.loadingService.show();
    this.subscriptions.push(this.visitService.saveVisits(this.visitsForGroup).subscribe(result => {
      this.visitsForGroup = result;
      this.loadingService.hide();
    }));
  }


  @ViewChild('template')
  modalContent: TemplateRef<any>;
  view: CalendarView = CalendarView.Week;
  CalendarView = CalendarView;

  viewDate: Date = new Date();

  refresh: Subject<any> = new Subject();

  events: CalendarEvent[] = [];

  handleEvent(action: string, event: CalendarEvent): void {
    this.modal.open(this.modalContent, {size: 'lg'});
  }

}
