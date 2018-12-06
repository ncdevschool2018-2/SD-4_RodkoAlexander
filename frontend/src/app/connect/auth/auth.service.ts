import { Injectable } from '@angular/core';
import {Account} from "../../model/account";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Token} from "../../model/token";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }



  attemptAuth(acc: Account): Observable<Token> {
    return this.http.post<Token>('/api/auth/token', acc);
  }
}
