import {Component, OnInit, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Account} from "../../model/account";
import {Router} from "@angular/router";
import {TokenProcessorService} from "../../util/pipe/token-processor.service";



@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {



  constructor(private router: Router,
              private tokenService: TokenProcessorService) {
  }

  ngOnInit() {
  }

  goToLogin() {
    this.router.navigateByUrl('/login')
  }

  loginStatus(): boolean {
    return !!sessionStorage.getItem("Token");
  }
  isAdmin(): boolean {
    return this.tokenService.isAdmin(sessionStorage.getItem("Token"))
  }
  signOut(){
    this.router.navigateByUrl('/login');
    sessionStorage.removeItem("Token");
  }
}
