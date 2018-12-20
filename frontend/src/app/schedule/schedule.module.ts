import {NgModule} from '@angular/core';
import {ScheduleComponent} from "./schedule/schedule.component";
import {CommonModule} from "@angular/common";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FormsModule} from "@angular/forms";
import {NgbModalModule, NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FlatpickrModule} from "angularx-flatpickr";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {UtilModule} from "../util/util.module";
import {AngularFontAwesomeModule} from "angular-font-awesome";
import {InputsModule} from "angular-bootstrap-md";
import {NgSelectModule} from "@ng-select/ng-select";
import {CalendarModule, DateAdapter} from "angular-calendar";
import {adapterFactory} from "angular-calendar/date-adapters/date-fns";


@NgModule({
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    FormsModule,
    NgbModalModule,
    FlatpickrModule.forRoot(),
    Ng4LoadingSpinnerModule.forRoot(),
    UtilModule,
    NgbModule,

    NgSelectModule,
    AngularFontAwesomeModule,
    InputsModule,
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory
    })
  ],
  declarations: [
    ScheduleComponent
  ]
})
export class ScheduleModule {
}
