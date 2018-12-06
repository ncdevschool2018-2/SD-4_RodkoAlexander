import {Injectable} from '@angular/core';
import {CanActivate, Router} from "@angular/router";
import {TokenProcessorService} from "./pipe/token-processor.service";

@Injectable({
  providedIn: 'root'
})
export class LoginGuardService implements CanActivate {

  constructor(public router: Router) {
  }

  canActivate(): boolean {

    if(sessionStorage.getItem("Token")) {
      this.router.navigateByUrl('/schedule');
      return false;
    }
      return true;
  }
}
