import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Lesson} from "../../model/lesson";

@Injectable({
  providedIn: 'root'
})
export class LessonService {

  constructor(private http: HttpClient) {
  }

  getLessons(): Observable<Lesson[]> {
    return this.http.get<Lesson[]>('/api/lessons');
  }

  saveLesson(lesson: Lesson): Observable<Lesson> {
    console.log(lesson);
    return this.http.post<Lesson>('/api/lessons', lesson);
  }

  deleteLesson(lessonId: string): Observable<void> {
    return this.http.delete<void>('/api/lessons/' + lessonId);
  }
}
