import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AccountComponent} from "./account/account.component";
import {StudentComponent} from "./student/student.component";
import {TeacherComponent} from "./teacher/teacher.component";
import {GroupComponent} from "./group/group.component";
import {LessonComponent} from "./lesson/lesson.component";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BsDropdownModule, ModalModule, TooltipModule} from "ngx-bootstrap";
import {ButtonsModule, CarouselModule, WavesModule} from "angular-bootstrap-md";
import {BrowserModule} from "@angular/platform-browser";
import {CalendarModule} from "primeng/primeng";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {OwlDateTimeModule, OwlNativeDateTimeModule} from "ng-pick-datetime";
import {NgMultiSelectDropDownModule} from 'ng-multiselect-dropdown';
import { NgSelectModule } from '@ng-select/ng-select';

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
    StudentComponent,
    TeacherComponent,
    GroupComponent,
    LessonComponent],
  exports: [
    AccountComponent,
    StudentComponent,
    TeacherComponent,
    GroupComponent,
    LessonComponent]
})
export class ModifyModule {
}
