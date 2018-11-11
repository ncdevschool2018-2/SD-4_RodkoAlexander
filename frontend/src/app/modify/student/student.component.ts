import {Component, OnInit, TemplateRef} from '@angular/core';
import {Student} from "../../model/student";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {StudentService} from "../../connect/student/student.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {GroupService} from "../../connect/group/group.service";
import {Group} from "../../model/group";
import {group} from "@angular/animations";

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  public editMode = false;

  public students: Student[];
  public groups: string[];
  public studentToEdit: Student = new Student();
  public modalEditor: BsModalRef;
  private subscriptions: Subscription[] = [];


  constructor(private studentService: StudentService,
              private groupsService: GroupService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) {

  }

  ngOnInit() {
    this.loadStudents();
    this.loadGroups();
  }


  public _closeModal(): void {
    this.modalEditor.hide();
  }

  public _openModal(template: TemplateRef<any>, student: Student): void {

    console.log(this.groups);
    if (student) {
      this.editMode = true;
      this.studentToEdit = Student.clone(student);
    } else {
      this.refreshStudentToEdit();
      this.editMode = false;
    }

    this.modalEditor = this.modalService.show(template);
  }

  public _addStudent(): void {
    this.loadingService.show();
    this.subscriptions.push(this.studentService.saveStudentWithAccount(this.studentToEdit).subscribe(() => {
      this._updateStudents();
      this.refreshStudentToEdit();
      this._closeModal();
      this.loadingService.hide();

    }));
  }

  public _updateStudents(): void {
    this.loadStudents();
  }

  public _deleteStudent(studentId: string): void {
    this.loadingService.show();
    this.subscriptions.push(this.studentService.deleteStudent(studentId).subscribe(() => {
      this._updateStudents();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  private refreshStudentToEdit(): void {
    this.studentToEdit = new Student();
  }

  private loadStudents(): void {
    this.loadingService.show();
    this.subscriptions.push(this.studentService.getStudents().subscribe(students => {

      this.students = students as Student[];

      console.log(this.students);
      this.loadingService.hide();
    }));
  }
  private loadGroups(): void {
    this.loadingService.show();
    this.subscriptions.push(this.groupsService.getGroupNumbers().subscribe(group => {
      this.groups = group as string[];
      this.loadingService.hide();
    }));
  }
}
