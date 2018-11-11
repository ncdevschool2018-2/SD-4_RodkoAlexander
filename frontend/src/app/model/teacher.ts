import {Account} from "./account";

export class Teacher {

  number: number;
  firstName: string;
  lastName: string;
  account: Account;

  get fullName(): string {
    return this.firstName + ' ' + this.lastName;
  }


  constructor(){
    this.account = new Account();
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
