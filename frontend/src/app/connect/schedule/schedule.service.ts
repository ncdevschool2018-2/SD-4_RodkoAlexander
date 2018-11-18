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

  getLessons(): Observable<Lesson[]> {
    return this.http.get<Lesson[]>('/api/schedule');
  }

  saveLesson(lesson: Lesson): Observable<Lesson> {
    console.log(lesson);
    return this.http.post<Lesson>('/api/schedule', lesson);
  }

  deleteLesson(id: number): Observable<void> {
    return this.http.delete<void>('/api/schedule/' + id);
  }
}
