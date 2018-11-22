import { Injectable } from '@angular/core';
import {HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class SecurityService {

  constructor() { }


  getSecurityHeaders():HttpHeaders{
    let security: HttpHeaders = new HttpHeaders();
    console.log("Bearer " + sessionStorage.getItem("Token"));
    security = security.set("Authorization","Bearer " + sessionStorage.getItem("Token"));
    return security;
  }
}
