import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {UserService} from "./user/user.service";
import {ScheduleService} from "./schedule/schedule.service";
import {GroupService} from "./group/group.service";
import {VisitService} from "./visit/visit.service";
import {AuthService} from "./auth/auth.service";
import {AuthenticationInterceptor} from "./auth/auth-interceptor";


@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
  ],
  declarations: [],
  providers: [UserService, ScheduleService, GroupService, VisitService,AuthService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthenticationInterceptor,
      multi: true,
    }],
})
export class ConnectModule {
}
