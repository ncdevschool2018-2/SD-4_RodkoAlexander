import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AccountToStudentPipe} from "./pipe/account-to-student/account-to-student.pipe";
import { StudentsToVisitsPipe } from './pipe/students-to-visits/students-to-visits.pipe';
import { GroupsNumbersPipe } from './pipe/groups-numbers/groups-numbers.pipe';
import { LessonsToCalendarEventsPipe } from './pipe/lessons-to-calendar-events/lessons-to-calendar-events.pipe';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [AccountToStudentPipe, StudentsToVisitsPipe, GroupsNumbersPipe, LessonsToCalendarEventsPipe],
  exports: [GroupsNumbersPipe],
  providers: [AccountToStudentPipe]
})
export class UtilModule {
}
