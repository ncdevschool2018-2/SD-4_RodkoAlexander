import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Teacher} from "../../model/teacher";

@Injectable({
  providedIn: 'root'
})
export class TeacherService {

  constructor(private http: HttpClient) {
  }

  getTeachers(): Observable<Teacher[]> {
    let teachers: Observable<Teacher[]>  = this.http.get<Teacher[]>('/api/teachers');
    console.log(teachers);
    return teachers;
  }

  saveTeacher(teacher: Teacher): Observable<Teacher> {
    return this.http.post<Teacher>('/api/teachers', teacher);
  }

  deleteTeacher(teacherId: string): Observable<void> {
    return this.http.delete<void>('/api/teachers/' + teacherId);
  }
}
