import {Account} from "./account";

export class Teacher {

  number: number;
  firstName: string;
  lastName: string;
  account: Account;

  constructor(){
    this.account = new Account();
    this.account.role = "Teacher";
  }

  static clone(student: Teacher): Teacher{
    let cloned: Teacher = new Teacher();
    cloned.number = student.number;
    cloned.firstName = student.firstName;
    cloned.lastName = student.lastName;
    cloned.account = student.account;
    return cloned;
  }


}
