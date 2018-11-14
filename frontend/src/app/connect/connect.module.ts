import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AccountService} from "./account/account.service";
import {LessonService} from "./lesson/lesson.service";
import {GroupService} from "./group/group.service";
import {HttpClientModule} from "@angular/common/http";
import {VisitService} from "./visit/visit.service";
import {UserService} from "./user/user.service";

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
  ],
  declarations: [],
  providers: [AccountService, UserService, LessonService, GroupService, VisitService]
})
export class ConnectModule {
}
