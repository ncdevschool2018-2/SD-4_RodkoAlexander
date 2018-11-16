import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AccountComponent} from "./table/account/account.component";
import {GroupComponent} from "./table/group/group.component";
import {LessonComponent} from "./table/lesson/lesson.component";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BsDropdownModule, ModalModule, TooltipModule} from "ngx-bootstrap";
import {ButtonsModule, CarouselModule, WavesModule} from "angular-bootstrap-md";
import {BrowserModule} from "@angular/platform-browser";
import {CalendarModule} from "primeng/primeng";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {OwlDateTimeModule, OwlNativeDateTimeModule} from "ng-pick-datetime";
import {NgSelectModule} from '@ng-select/ng-select';
import { TeacherScheduleComponent } from './teacher-schedule/teacher-schedule.component';
import { StudentScheduleComponent } from './student-schedule/student-schedule.component';
import { AccountToStudentPipe } from './account-to-student.pipe';

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    Ng4LoadingSpinnerModule.forRoot(),
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
    CarouselModule.forRoot(),
    WavesModule.forRoot(),
    ButtonsModule,
    CalendarModule,
    BrowserAnimationsModule,
    OwlDateTimeModule,
    OwlNativeDateTimeModule,
    NgSelectModule
  ],
  declarations: [
    AccountComponent,
    GroupComponent,
    LessonComponent,
    TeacherScheduleComponent,
    StudentScheduleComponent,
    AccountToStudentPipe],
  exports: [
    AccountComponent,
    GroupComponent,
    LessonComponent],
  providers:[AccountToStudentPipe]
})
export class ModifyModule {
}
