import {Injectable} from '@angular/core';
import * as jwt_decode from "jwt-decode";

@Injectable({
  providedIn: 'root'
})
export class TokenProcessorService {

  constructor() {
  }

  public isAdmin(token: string): boolean {
    return jwt_decode(sessionStorage.getItem("Token"))["Role"] == "Administrator";
  }

  public isTeacher(token: string): boolean {
    return jwt_decode(sessionStorage.getItem("Token"))["Role"] == "Teacher";
  }

  public isStudents(token: string): boolean {
    return jwt_decode(sessionStorage.getItem("Token"))["Role"] == "Student";
  }
}
