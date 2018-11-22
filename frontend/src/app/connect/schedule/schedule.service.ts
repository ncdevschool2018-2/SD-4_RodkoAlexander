import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Lesson} from "../../model/lesson";
import {SecurityService} from "../security/security.service";

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {

  constructor(private http: HttpClient,private security: SecurityService) {
  }

  getLessons(): Observable<Lesson[]> {
    return this.http.get<Lesson[]>('/api/schedule',{headers : this.security.getSecurityHeaders()});
  }

  saveLesson(lesson: Lesson): Observable<Lesson> {
    console.log(lesson);
    return this.http.post<Lesson>('/api/schedule', lesson,{headers : this.security.getSecurityHeaders()});
  }

  deleteLesson(id: number): Observable<void> {
    return this.http.delete<void>('/api/schedule/' + id,{headers : this.security.getSecurityHeaders()});
  }
}
