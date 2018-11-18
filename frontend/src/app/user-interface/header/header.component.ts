import {Component, OnInit, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Account} from "../../model/account";

@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {


  private modalEditor: BsModalRef;
  public accountToLogin: Account = new Account();
  constructor(private modalService: BsModalService) {
  }

  ngOnInit() {
  }

  public _closeModal(): void {
    this.modalEditor.hide();
  }

  public _openModal(template: TemplateRef<any>): void {
    this.modalEditor = this.modalService.show(template);
  }
}
