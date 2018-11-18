import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {RouterModule} from '@angular/router';
import {Router} from "./router";
import {ConnectModule} from "./connect/connect.module";
import {ModifyModule} from "./modify/modify.module";
import {UserInterfaceModule} from "./user-interface/user-interface.module";
import {TabModule} from "angular-tabs-component";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {CalendarModule, DateAdapter} from "angular-calendar";
import {adapterFactory} from "angular-calendar/date-adapters/date-fns";
import {ScheduleModule} from "./schedule/schedule.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    RouterModule.forRoot(Router.routes()),
    UserInterfaceModule,
    BrowserModule,
    ConnectModule,
    ModifyModule,
    ScheduleModule,
    TabModule,
    BrowserAnimationsModule,
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory
    })
  ],
  entryComponents: [],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {

}
