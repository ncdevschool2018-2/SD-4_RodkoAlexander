import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Student} from "../../data/student";

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http: HttpClient) {
  }

  getStudents(): Observable<Student[]> {
    let students: Observable<Student[]>  = this.http.get<Student[]>('/api/students');
    console.log(students);
    return students;
  }

  saveStudent(student: Student): Observable<Student> {
    return this.http.post<Student>('/api/students', student);
  }

  deleteStudent(studentId: string): Observable<void> {
    return this.http.delete<void>('/api/students/' + studentId);
  }
}
