import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Subject} from "../../model/subject";

@Injectable({
  providedIn: 'root'
})
export class SubjectService {

  constructor(private http: HttpClient) {
  }

  getSubjects(page: number, size: number): Observable<Subject[]> {
    return this.http.get<Subject[]>('/api/subjects?page=' + page + '&size=' + size);
  }

  getSubjectByAbbreviation(abbreviation: string): Observable<Subject[]> {
    return this.http.get<Subject[]>('/api/subjects?abb=' + abbreviation);
  }

  saveSubject(subject: Subject): Observable<Subject> {
    return this.http.post<Subject>('/api/subjects', subject);
  }

  deleteSubject(id: number): Observable<void> {
    return this.http.delete<void>('/api/subjects/' + id);
  }


  count(): Observable<number> {
    return this.http.get<number>('/api/subjects/count');
  }
}
