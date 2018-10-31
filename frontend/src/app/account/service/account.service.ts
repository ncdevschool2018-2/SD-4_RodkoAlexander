import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Account} from "../../data/account";

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

  deleteAccount(accountId: string): Observable<void> {
    return this.http.delete<void>('/api/accounts/' + accountId);
  }

}
