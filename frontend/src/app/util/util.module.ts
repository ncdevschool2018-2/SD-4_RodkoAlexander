import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AccountToStudentPipe} from "./pipe/account-to-student/account-to-student.pipe";
import { StudentsToVisitsPipe } from './pipe/students-to-visits/students-to-visits.pipe';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [AccountToStudentPipe, StudentsToVisitsPipe],

  providers: [AccountToStudentPipe]
})
export class UtilModule {
}
