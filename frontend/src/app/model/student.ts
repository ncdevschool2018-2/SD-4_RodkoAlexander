import {Account} from "./account";

export class Student {

  account: Account;
  groupId: number;

  constructor() {
    this.account = new Account();
  }


  static clone(student: Student): Student {
    let cloned: Student = new Student();
    cloned.account = student.account;
    cloned.groupId = student.groupId;
    return cloned;
  }

}
