import {Account} from "./account";

export class Student {
  number: number;
  firstName: string;
  lastName: string;
  groupNumber: string;
  account: Account;

  constructor(){}

  static clone(student: Student): Student{
    let cloned: Student = new Student();
    cloned.number = student.number;
    cloned.firstName = student.firstName;
    cloned.lastName = student.lastName;
    cloned.groupNumber = student.groupNumber;
    cloned.account = student.account;
    return cloned;
  }
}
