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
    return this.http.post<Account>('/api/accounts', account);
  }

  saveStudent(student: Student): Observable<Account> {
    return this.http.post<Account>('/api/accounts/students', student);
  }

  deleteAccount(id: number): Observable<void> {
    return this.http.delete<void>('/api/accounts/' + id);
  }

  deleteStudent( id: number): Observable<void> {
    return this.http.delete<void>('/api/accounts/students/' + id);
  }

  getAll(page: number, size: number): Observable<Account[]> {
    return this.http.get<Account[]>('/api/accounts/?page=' + page + '&size=' + size);
  }

  getRoles(): Observable<Role[]> {
    return this.http.get<Role[]>('/api/roles');
  }

  findByLastName(lastName: string): Observable<Account[]> {
    return this.http.get<Account[]>('/api/accounts?lastName=' + lastName);
  }

  findAccountsByLastNameAndRole(lastNameSearchParam: string, roleId: number) {
    return this.http.get<Account[]>('/api/accounts?lastName=' + lastNameSearchParam + '&roleId=' + roleId);
  }

  findUsersByLastNameAndRole(lastName: string, role: number): Observable<User[]> {
    return this.http.get<User[]>('/api/users?lastName=' + lastName+'&role=' + role);
  }

  getStudentsFromGroup(groupId: number): Observable<User[]> {
    return this.http.get<User[]>('/api/groups/' + groupId + '/students');
  }

  count(): Observable<number> {
    return this.http.get<number>('/api/accounts/count');
  }

  transferStudent(newGroup: number, id: number) {
    return this.http.put('/api/accounts/students?new=' + newGroup + '&id=' +id,null);
  }
}
