import {Component, OnInit} from '@angular/core';
import {Account} from "../../model/account";
import {AuthService} from "../../connect/auth/auth.service";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  loginAccount: Account;
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  private subscriptions: Subscription[] = [];

  constructor(private authService: AuthService,
              private loadingService: Ng4LoadingSpinnerService,
              private router:Router) {
    this.loginAccount = new Account();
  }

  ngOnInit() {
    if (sessionStorage.getItem("Token")) {
      this.isLoggedIn = true;
    }
  }

  onSubmit() {
    this.authService.attemptAuth(this.loginAccount);
  }

  reloadPage() {
    window.location.reload();
  }

  loginTry() {
    this.loadingService.show();
    this.subscriptions.push(this.authService.attemptAuth(this.loginAccount).subscribe(token => {
        if (token) {
          console.log(token.token);
          sessionStorage.setItem("Token", token.token);
          this.router.navigateByUrl("/modify");
        }
        else console.log("something bad");

      }
    ));
    this.loadingService.show();

  }

}
