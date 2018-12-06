import {Component, OnInit} from '@angular/core';
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
export class LoginComponent implements OnInit {


  loginAccount: Account;
  private subscriptions: Subscription[] = [];

  constructor(private authService: AuthService,
              private router: Router,
              private tokenService: TokenProcessorService) {
    this.loginAccount = new Account();
  }

  ngOnInit() {

  }


  loginTry() {
    this.subscriptions.push(this.authService.attemptAuth(this.loginAccount).subscribe(token => {
        if (token) {
          sessionStorage.setItem("Token", token.token);
          if (this.tokenService.isAdmin(token.token))
          this.router.navigateByUrl("/modify");
          else this.router.navigateByUrl("/schedule")
        } else console.log("something bad");

      }
    ));

  }

}
