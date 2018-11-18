import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Account} from "../../model/account";
import {Student} from "../../model/student";
import {User} from "../../model/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  getAccounts(): Observable<Account[]> {
    return this.http.get<Account[]>('/api/users/employers');
  }

  saveAccount(account: Account): Observable<Account> {
    return this.http.post<Account>('/api/users', account);
  }

  saveStudent(student: Student): Observable<Account> {
    console.log(student);
    return this.http.post<Account>('/api/users/students', student);
  }

  deleteAccount(id: number): Observable<void> {
    return this.http.delete<void>('/api/users/' + id);
  }

  getTeachers(): Observable<User[]> {
    return this.http.get<User[]>('/api/users/teachers');
  }

  getStudentsFromGroup(groupId: number): Observable<User[]> {
    return this.http.get<User[]>('/api/groups/' + groupId + '/students');
  }
}
