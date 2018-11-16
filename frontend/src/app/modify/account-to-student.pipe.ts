import { Pipe, PipeTransform } from '@angular/core';
import {Account} from "../model/account";
import {Student} from "../model/student";

@Pipe({
  name: 'accountToStudent'
})
export class AccountToStudentPipe implements PipeTransform {

  transform(value: Account, groupNumber: number): Student {
    let student: Student = new Student();
    student.account = Account.clone(value);
    student.groupNumber = groupNumber;
    return student;
  }

}
