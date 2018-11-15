import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {User} from "../../model/user";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>('/api/users');
  }

  saveUser(user: User): Observable<User> {
    return this.http.post<User>('/api/users', user);
  }

  deleteUser(id: number): Observable<void> {
    return this.http.delete<void>('/api/users/' + id);
  }

  getStudents(): Observable<User[]> {
    return this.http.get<User[]>('/api/users/students');
  }

  getTeachers(): Observable<User[]> {
    return this.http.get<User[]>('/api/users/teachers');
  }

  getAdministrators(): Observable<User[]> {
    return this.http.get<User[]>('/api/users/administrators');
  }

}
