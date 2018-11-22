import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Account} from "../../model/account";
import {Student} from "../../model/student";
import {User} from "../../model/user";
import {Role} from "../../model/role";
import {hebrewNumerals} from "@ng-bootstrap/ng-bootstrap/datepicker/hebrew/hebrew";
import {SecurityService} from "../security/security.service";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient,private security: SecurityService) {
  }

  getAccounts(): Observable<Account[]> {

    return this.http.get<Account[]>('/api/users/employers',{headers : this.security.getSecurityHeaders()});
  }

  saveAccount(account: Account): Observable<Account> {
    return this.http.post<Account>('/api/users', account,{headers : this.security.getSecurityHeaders()});
  }

  saveStudent(student: Student): Observable<Account> {
    console.log(student);
    return this.http.post<Account>('/api/users/students', student,{headers : this.security.getSecurityHeaders()});
  }

  deleteAccount(id: number): Observable<void> {
    return this.http.delete<void>('/api/users/' + id,{headers : this.security.getSecurityHeaders()});
  }

  getTeachers(): Observable<User[]> {
    return this.http.get<User[]>('/api/users/teachers',{headers : this.security.getSecurityHeaders()});
  }

  getStudentsFromGroup(groupId: number): Observable<User[]> {
    return this.http.get<User[]>('/api/groups/' + groupId + '/students',{headers : this.security.getSecurityHeaders()});
  }

  getRoles(): Observable<Role[]> {
    return this.http.get<Role[]>('/api/users/roles',{headers : this.security.getSecurityHeaders()});
  }

}
