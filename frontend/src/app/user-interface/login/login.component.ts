import {Component, OnDestroy, OnInit} from '@angular/core';
import {Account} from "../../model/account";
import {AuthService} from "../../connect/auth/auth.service";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";
import {TokenProcessorService} from "../../util/pipe/token-processor.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit,OnDestroy {


  loginAccount: Account;
  private subscriptions: Subscription[] = [];
  public error: string = "";

  constructor(private authService: AuthService,
              private router: Router,
              private tokenService: TokenProcessorService) {
    this.loginAccount = new Account();
  }

  ngOnInit() {

  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => {sub.unsubscribe()})
  }

  loginTry() {
    this.subscriptions.push(this.authService.attemptAuth(this.loginAccount).subscribe(token => {
        if (token) {
          sessionStorage.setItem("Token", token.token);
          if (this.tokenService.isAdmin(token.token))
          this.router.navigateByUrl("/modify");
          else this.router.navigateByUrl("/schedule")
        } else console.log("something bad");

      },error1 => {
      this.error = "Bad credentials";
      }
    ));

  }

}
