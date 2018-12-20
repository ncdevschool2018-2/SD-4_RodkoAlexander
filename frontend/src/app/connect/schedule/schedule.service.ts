import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Lesson} from "../../model/lesson";

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {

  constructor(private http: HttpClient) {
  }

  getLessonsByTeacher(number: number, dateToLoadFrom: string,dateToLoadTo: string): Observable<Lesson[]> {
    return this.http.get<Lesson[]>('/api/schedule/teacher/'+number+'?dateFrom='+dateToLoadFrom+'&dateTo='+dateToLoadTo);
  }

  getLessonsByGroup(number: number, dateToLoadFrom: string,dateToLoadTo: string): Observable<Lesson[]> {
    return this.http.get<Lesson[]>('/api/schedule/group/'+number+'?dateFrom='+dateToLoadFrom+'&dateTo='+dateToLoadTo);
  }

  getLessons(page: number, size :number): Observable<Lesson[]> {
    return this.http.get<Lesson[]>('/api/schedule/?page='+page+'&size='+size);
  }

  count(): Observable<number> {
    return this.http.get<number>('/api/schedule/count');
  }

  saveLesson(lesson: Lesson): Observable<Lesson> {
    return this.http.post<Lesson>('/api/schedule', lesson);
  }

  deleteLesson(id: number): Observable<void> {
    return this.http.delete<void>('/api/schedule/' + id);
  }


}
