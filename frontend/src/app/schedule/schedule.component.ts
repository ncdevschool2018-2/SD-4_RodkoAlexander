import {Component, OnInit, TemplateRef} from '@angular/core';
import {Lesson} from '../data/lesson';
import {LessonService} from "./lesson.service";
import {Subscription} from "rxjs";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})

export class ScheduleComponent implements OnInit {

  public editMode = false;

  public loadedLessons: Lesson[];
  public lessonToEdit: Lesson = new Lesson();
  public modalRef: BsModalRef;

/*
  constructor() {


    this.days = [ WeekDay.Monday, WeekDay.Tuesday, WeekDay.Wednesday, WeekDay.Thursday, WeekDay.Friday , WeekDay.Saturday ];
    this.date = new Date().toDateString();
    this.classes = [new Lesson('KIT', '13.25-15.00', 'Rusetski', '607-5', LessonType.Practical),
      new Lesson('KIT', '13.25-15.00', 'Rusetski', '607-5', LessonType.Practical),
      new Lesson('KIT', '13.25-15.00', 'Rusetski', '607-5', LessonType.Practical)];
    this.header = new Lesson('Lesson', 'Time', 'Teacher', 'Audithorium', 'Type');
  }
*/

  private subscriptions: Subscription[] = [];


  // Dependency injection for BillingAccountService into Billing
  constructor(private lessonService: LessonService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) { //to show the modal, we also need the ngx-bootstrap service
  }

  // Calls on component init
  ngOnInit() {
    this.loadLessons();
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, lesson: Lesson): void {

    if (lesson) {
      this.editMode = true;
      this.lessonToEdit = Lesson.clone(lesson);
    } else {
      this.refreshLesson();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                      // we keep the modal reference and pass the template local name to the modalService.
  }

  public _addLesson(): void {
    this.loadingService.show();
    this.subscriptions.push(this.lessonService.saveLesson(this.lessonToEdit).subscribe(() => {
      console.log(this.lessonToEdit);
      this._updateLessons();
      this.refreshLesson();
      this._closeModal();
      this.loadingService.hide();

    }));
  }

  public _updateLessons(): void {
    this.loadLessons();
  }

  public _deleteLessonById(lessonId: string): void {
    this.loadingService.show();
    this.subscriptions.push(this.lessonService.deleteLesson(lessonId).subscribe(() => {
      this._updateLessons();
    }));
  }

  private refreshLesson(): void {
    this.lessonToEdit = new Lesson();
  }

  private loadLessons(): void {
    this.loadingService.show();
    // Get data from LessonService
    this.subscriptions.push(this.lessonService.getLessons().subscribe(lessons => {
      // Parse json response into local array
      this.loadedLessons = lessons as Lesson[];
      this.loadingService.hide();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}
