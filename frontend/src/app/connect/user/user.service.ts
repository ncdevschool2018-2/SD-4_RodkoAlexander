import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Account} from "../../model/account";
import {Student} from "../../model/student";
import {User} from "../../model/user";
import {Role} from "../../model/role";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {

  }

  saveAccount(account: Account): Observable<Account> {
    return this.http.post<Account>('/api/users', account);
  }

  saveStudent(student: Student): Observable<Account> {
    return this.http.post<Account>('/api/users/students', student);
  }

  deleteAccount(id: number): Observable<void> {
    return this.http.delete<void>('/api/users/' + id);
  }

  deleteStudent(groupId: number, id: number): Observable<void> {
    return this.http.delete<void>('/api/groups/' + groupId + '/' + id);
  }

  getAll(page: number, size: number): Observable<Account[]> {
    return this.http.get<Account[]>('/api/users/?page=' + page + '&size=' + size);
  }

  getRoles(): Observable<Role[]> {
    return this.http.get<Role[]>('/api/users/roles');
  }

  findByLastName(lastName: string): Observable<Account[]> {
    return this.http.get<Account[]>('/api/users?lastName=' + lastName);
  }

  findByLastNameAndRole(lastNameSearchParam: string, roleId: number) {
    return this.http.get<Account[]>('/api/users?lastName=' + lastNameSearchParam + '&roleId=' + roleId);
  }

  getTeachers(): Observable<User[]> {
    return this.http.get<User[]>('/api/users/teachers');
  }

  findTeachersByLastName(lastName: string): Observable<User[]> {
    return this.http.get<User[]>('/api/users/teachers?lastName=' + lastName);
  }

  getStudentsFromGroup(groupId: number): Observable<User[]> {
    return this.http.get<User[]>('/api/groups/' + groupId + '/students');
  }

  count(): Observable<number> {
    return this.http.get<number>('/api/users/count');
  }

  transfer(oldGroup: number, newGroup: number, id: number) {
    return this.http.get<Account>('/api/users/students?old=' + oldGroup + '&new=' + newGroup + '&id=' +id );
  }
}
