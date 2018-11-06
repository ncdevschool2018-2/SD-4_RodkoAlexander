import {Account} from "./account";

export class Teacher {
  number: number;
  firstName: string;
  lastName: string;
  account: Account;

  constructor(){}


  static clone(student: Teacher): Teacher{
    let cloned: Teacher = new Teacher();
    cloned.number = student.number;
    cloned.firstName = student.firstName;
    cloned.lastName = student.lastName;
    cloned.account = student.account;
    return cloned;
  }

}
