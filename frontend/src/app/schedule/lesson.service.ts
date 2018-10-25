import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Lesson} from "../data/lesson";

@Injectable({
  providedIn: 'root'
})
export class LessonService {

  constructor(private http: HttpClient) {
  }

  // Ajax request for billing account data
  getLessons(): Observable<Lesson[]> {
    return this.http.get<Lesson[]>('/api/ls');
  }

  saveLesson(lesson: Lesson): Observable<Lesson> {
    return this.http.post<Lesson>('/api/ls', lesson);
  }

  deleteLesson(lessonId: string): Observable<void> {
    return this.http.delete<void>('/api/ls/' + lessonId);
  }
}
