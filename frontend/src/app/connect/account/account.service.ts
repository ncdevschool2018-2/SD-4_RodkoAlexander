import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Account} from "../../model/account";
import {Student} from "../../model/student";

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http: HttpClient) {
  }

  getAccounts(): Observable<Account[]> {
    return this.http.get<Account[]>('/api/accounts');
  }

  saveAccount(account: Account): Observable<Account> {
    return this.http.post<Account>('/api/accounts', account);
  }

  saveStudent(student: Student): Observable<Account> {
    console.log(student);
    return this.http.post<Account>('/api/accounts/students', student);
  }

  deleteAccount(id: number): Observable<void> {
    return this.http.delete<void>('/api/accounts/' + id);
  }

}
