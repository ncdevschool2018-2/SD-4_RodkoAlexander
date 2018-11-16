import {User} from "./user";
import {Account} from "./account";

export class Student {

  account: Account;
  groupNumber: number;

  constructor() {
    this.account = new Account();
  }


  static clone(student: Student): Student {
    let cloned: Student = new Student();
    cloned.account = student.account;
    cloned.groupNumber = student.groupNumber;
    return cloned;
  }

}
