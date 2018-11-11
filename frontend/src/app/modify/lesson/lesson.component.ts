import {Component, OnInit, TemplateRef} from '@angular/core';
import {Lesson} from "../../model/lesson";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {LessonService} from "../../connect/lesson/lesson.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";

@Component({
  selector: 'app-lesson',
  templateUrl: './lesson.component.html',
  styleUrls: ['./lesson.component.css']
})
export class LessonComponent implements OnInit {

  public editMode = false;

  public lessons: Lesson[];
  public lessonToEdit: Lesson = new Lesson();
  public modalEditor: BsModalRef;
  private subscriptions: Subscription[] = [];


  constructor(private lessonService: LessonService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) {

  }

  ngOnInit() {
    this.loadLessons();
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
    this.loadingService.show();
    this.subscriptions.push(this.lessonService.saveLesson(this.lessonToEdit).subscribe(() => {
      this._updateLessons();
      this.refreshLessonToEdit();
      this._closeModal();
      this.loadingService.hide();

    }));
  }

  public _updateLessons(): void {
    this.loadLessons();
  }

  public _deleteLesson(lessonId: string): void {
    this.loadingService.show();
    this.subscriptions.push(this.lessonService.deleteLesson(lessonId).subscribe(() => {
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
    this.subscriptions.push(this.lessonService.getLessons().subscribe(lessons => {


      this.lessons = lessons;

      console.log(this.lessons);
      this.loadingService.hide();
    }));
  }
}
