import {Component, OnInit, TemplateRef} from '@angular/core';
import {Teacher} from "../model/teacher";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {TeacherService} from "./service/teacher.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";

@Component({
  selector: 'app-teacher',
  templateUrl: './teacher.component.html',
  styleUrls: ['./teacher.component.css']
})
export class TeacherComponent implements OnInit {


  public editMode = false;

  public teachers: Teacher[];
  public teacherToEdit: Teacher = new Teacher();
  public modalEditor: BsModalRef;
  private subscriptions: Subscription[] = [];


  constructor(private teacherService: TeacherService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) {

  }

  ngOnInit() {
    this.loadTeachers();
  }


  public _closeModal(): void {
    this.modalEditor.hide();
  }

  public _openModal(template: TemplateRef<any>, teacher: Teacher): void {

    if (teacher) {
      this.editMode = true;
      this.teacherToEdit = Teacher.clone(teacher);
    } else {
      this.refreshTeacherToEdit();
      this.editMode = false;
    }

    this.modalEditor = this.modalService.show(template);
  }

  public _addTeacher(): void {
    this.loadingService.show();
    this.subscriptions.push(this.teacherService.saveTeacher(this.teacherToEdit).subscribe(() => {
      this._updateTeachers();
      this.refreshTeacherToEdit();
      this._closeModal();
      this.loadingService.hide();

    }));
  }

  public _updateTeachers(): void {
    this.loadTeachers();
  }

  public _deleteTeacher(teacherId: string): void {
    this.loadingService.show();
    this.subscriptions.push(this.teacherService.deleteTeacher(teacherId).subscribe(() => {
      this._updateTeachers();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  private refreshTeacherToEdit(): void {
    this.teacherToEdit = new Teacher();
  }

  private loadTeachers(): void {
    this.loadingService.show();
    this.subscriptions.push(this.teacherService.getTeachers().subscribe(teachers => {

      this.teachers = teachers as Teacher[];

      console.log(this.teachers);
      this.loadingService.hide();
    }));
  }
}
