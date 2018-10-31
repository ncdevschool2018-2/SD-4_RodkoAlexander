export class Student {
  number: number;
  firstName: string;
  lastName: string;
  groupNumber: string;
  accountId: number;

  constructor(){}


  static clone(student: Student): Student{
    let cloned: Student = new Student();
    cloned.number = student.number;
    cloned.firstName = student.firstName;
    cloned.lastName = student.lastName;
    cloned.groupNumber = student.groupNumber;
    cloned.accountId = student.accountId;
    return cloned;
  }

}
