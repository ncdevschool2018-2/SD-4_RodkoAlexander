import {Component, OnInit, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Subject} from "../../../model/subject";
import {SubjectService} from "../../../connect/subject/subject.service";

@Component({
  selector: 'app-subject',
  templateUrl: './subject.component.html',
  styleUrls: ['./subject.component.css']
})
export class SubjectComponent implements OnInit {

  public editMode = false;
  public subjects: Subject[];
  public subjectToEdit: Subject = new Subject();
  public modalEditor: BsModalRef;
  private subscriptions: Subscription[] = [];
  totalElements: number = 0;
  pageNumber: number = 1;
  elementsToView: number = 25;
  searchParam: string = '';
  searchValue: string = '';
  findParams: string[] = ['course', 'number'];


  constructor(private subjectService: SubjectService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) {

  }

  ngOnInit() {
    this._loadPage();
    this._updateNumberOfEntries();
  }


  public _closeModal(): void {
    this.modalEditor.hide();
  }

  public _openModal(template: TemplateRef<any>, subject: Subject): void {

    if (subject) {
      this.editMode = true;
      this.subjectToEdit = Subject.clone(subject);
    } else {
      this._refreshSubjectToEdit();
      this.editMode = false;
    }

    this.modalEditor = this.modalService.show(template);
  }

  public _addSubject(): void {
    this.loadingService.show();
    this.subscriptions.push(this.subjectService.saveSubject(this.subjectToEdit).subscribe(() => {
      this._updateSubjects();
      this._updateNumberOfEntries();
      this._refreshSubjectToEdit();
      this._closeModal();
      this.loadingService.hide();

    }));
  }

  public _updateSubjects(): void {
    this._loadPage();
  }

  public _deleteSubject(id: number): void {
    this.loadingService.show();
    this.subscriptions.push(this.subjectService.deleteSubject(id).subscribe(() => {
      this._updateSubjects();
      this._updateNumberOfEntries();
      this.loadingService.hide();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  private _refreshSubjectToEdit(): void {
    this.subjectToEdit = new Subject();
  }

  private _loadPage(): void {
    this.loadingService.show();
    this.subscriptions.push(this.subjectService.getSubjects(this.pageNumber - 1, this.elementsToView).subscribe(subjects => {
      this.subjects = subjects;
      this.loadingService.hide();
    }));
  }


  private _updateNumberOfEntries(): void {
    this.subscriptions.push(this.subjectService.count().subscribe(numberOfEntries => {
      this.totalElements = numberOfEntries;
    }));
  }

  _search() {
    this.loadingService.show();
    this.subscriptions.push(
      this.subjectService.getSubjectByAbbreviation(this.searchValue).subscribe(subjects => {
        this.subjects = subjects;
        this.loadingService.hide();
      }));
  }



  _getAcronym(){
    let str :string = this.subjectToEdit.fullName;
    let matches = str.match(/\b(\w)/g);
    this.subjectToEdit.abbreviation = matches.join('');
  }
}
