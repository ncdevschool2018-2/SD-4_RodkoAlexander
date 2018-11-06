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
import {StudentService} from "./student/service/student.service";
import {AccountService} from "./account/service/account.service";
import { TeacherComponent } from './teacher/teacher.component';
import { GroupComponent } from './group/group.component';
import {RouterModule} from '@angular/router';
import { StartComponent } from './start/start.component';
import {Router} from "./router";
import { CarouselModule, WavesModule, ButtonsModule } from 'angular-bootstrap-md';
import { LessonComponent } from './lesson/lesson.component'


@NgModule({
  declarations: [
    HeaderComponent,
    AppComponent,
    AccountComponent,
    StudentComponent,
    TeacherComponent,
    GroupComponent,
    StartComponent,
    LessonComponent
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
    ModalModule.forRoot(),
    RouterModule.forRoot(Router.routes()),
    CarouselModule.forRoot(),
    WavesModule.forRoot(),
    ButtonsModule
  ],
  entryComponents: [],
  providers: [StudentService,AccountService],
  bootstrap: [AppComponent]
})
export class AppModule {

}
