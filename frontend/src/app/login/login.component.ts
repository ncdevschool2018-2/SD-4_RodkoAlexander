import { Component, Input } from '@angular/core';
import {FormGroup, FormBuilder, FormControl} from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',

})
export class LoginComponent {

  @Input()id: number;
  scheduleLoginForm: FormGroup;
  constructor(
    public activeModal: NgbActiveModal,
    private formBuilder: FormBuilder
  ) {
    this.createForm();
  }
  private createForm() {
    this.scheduleLoginForm = new FormGroup({
      email: new FormControl(),
      password: new FormControl()
    });
  }
  private submitForm() {
    this.activeModal.close(this.scheduleLoginForm.value);
  }
}
