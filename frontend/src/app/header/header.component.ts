import {Component, OnInit} from '@angular/core';
import { LoginComponent } from "../login/login.component";
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private modalService: NgbModal) {
  }

  ngOnInit() {
  }

  openFormModal() {
    const modalRef = this.modalService.open(LoginComponent);
  }

}
