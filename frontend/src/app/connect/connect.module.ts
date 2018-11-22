import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HttpClientModule} from "@angular/common/http";
import {UserService} from "./user/user.service";
import {ScheduleService} from "./schedule/schedule.service";
import {GroupService} from "./group/group.service";
import {VisitService} from "./visit/visit.service";
import {AuthService} from "./auth/auth.service";


@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
  ],
  declarations: [],
  providers: [UserService, ScheduleService, GroupService, VisitService,AuthService]
})
export class ConnectModule {
}
