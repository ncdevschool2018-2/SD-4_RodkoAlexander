import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {HeaderComponent} from './header/header.component';
import {ScheduleComponent} from './schedule/schedule.component';
import {ModalModule} from './modal/modal.module';
import {LoginComponent} from './modal/login/login.component';

@NgModule({
  declarations: [
    HeaderComponent,
    ScheduleComponent
  ],
  imports: [
    BrowserModule,
    ModalModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [HeaderComponent,
    ScheduleComponent,
  LoginComponent]
})
export class AppModule {
}
