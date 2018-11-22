import {Component, OnInit, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Account} from "../../model/account";
import {Router} from "@angular/router";



@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {


  private modalEditor: BsModalRef;
  public accountToLogin: Account = new Account();
  constructor(private modalService: BsModalService,
              private router: Router) {
  }

  ngOnInit() {
  }

  goToLogin() {
    this.router.navigateByUrl('/login')
  }

  loginStatus(): boolean {
    return !!sessionStorage.getItem("Token");
  }
}
