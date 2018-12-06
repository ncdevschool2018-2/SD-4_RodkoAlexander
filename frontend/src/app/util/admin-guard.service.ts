import { Injectable } from '@angular/core';
import {CanActivate, Router} from "@angular/router";
import {TokenProcessorService} from "./pipe/token-processor.service";

@Injectable({
  providedIn: 'root'
})
export class AdminGuardService implements CanActivate{

  constructor(private tokenProcessorService: TokenProcessorService,
              private router: Router) {}

  canActivate(): boolean {
    if (!this.tokenProcessorService.isAdmin(sessionStorage.getItem("Token"))) {
      this.router.navigateByUrl('/schedule');
      return false;
    }
    return true;
  }
}
