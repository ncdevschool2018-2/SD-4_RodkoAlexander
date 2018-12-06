import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';
import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {tap} from "rxjs/operators";
import {Router} from "@angular/router";

@Injectable()
export class AuthenticationInterceptor implements HttpInterceptor {


  constructor(private router: Router) {
  }


  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authReq = req;
    if (sessionStorage.getItem("Token")) {
      authReq = req.clone({headers: req.headers.set("Authorization", 'Bearer ' + sessionStorage.getItem("Token"))});
    }
    return next.handle(authReq).pipe(tap((event: HttpEvent<any>) => {
      }, (err: any) => {
        if (err instanceof HttpErrorResponse) {
          if (err.status === 401) {
            sessionStorage.removeItem("Token");
            this.router.navigateByUrl('/login');
          }
        }
      }
    ));

  }
}
