import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {HeaderComponent} from './header/header.component';
import {ScheduleComponent} from './schedule/schedule.component';
import {LoginComponent} from './login/login.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {BsDropdownModule, ModalModule, TooltipModule} from "ngx-bootstrap";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";


@NgModule({
  declarations: [
    HeaderComponent,
    ScheduleComponent,
    LoginComponent,
    AppComponent
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
  entryComponents: [LoginComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
