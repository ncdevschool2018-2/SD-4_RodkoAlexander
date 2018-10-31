import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {HeaderComponent} from './header/header.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {BsDropdownModule, ModalModule, TooltipModule} from "ngx-bootstrap";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import { AccountComponent } from './account/account.component';
import { StudentComponent } from './student/student.component';


@NgModule({
  declarations: [
    HeaderComponent,
    AppComponent,
    AccountComponent,
    StudentComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    Ng4LoadingSpinnerModule.forRoot(),
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot()
  ],
  entryComponents: [],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
