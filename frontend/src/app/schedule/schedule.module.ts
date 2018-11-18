import {NgModule} from '@angular/core';
import {ScheduleComponent} from "./schedule/schedule.component";
import {CommonModule} from "@angular/common";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import {FormsModule} from "@angular/forms";
import {NgbModalModule} from "@ng-bootstrap/ng-bootstrap";
import {FlatpickrModule} from "angularx-flatpickr";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";


@NgModule({
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory
    }),
    FormsModule,
    NgbModalModule,
    FlatpickrModule.forRoot(),
    Ng4LoadingSpinnerModule.forRoot()
  ],
  declarations: [
    ScheduleComponent
  ]
})
export class ScheduleModule {
}
