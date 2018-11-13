import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {StudentService} from "./student/student.service";
import {AccountService} from "./account/account.service";
import {TeacherService} from "./teacher/teacher.service";
import {LessonService} from "./lesson/lesson.service";
import {GroupService} from "./group/group.service";
import {HttpClientModule} from "@angular/common/http";
import {VisitService} from "./visit/visit.service";

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
  ],
  declarations: [],
  providers: [StudentService, AccountService, TeacherService, LessonService, GroupService, VisitService]
})
export class ConnectModule {
}
