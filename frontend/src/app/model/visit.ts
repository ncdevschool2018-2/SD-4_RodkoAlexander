import {Lesson} from "./lesson";
import {Account} from "./account";

export class Visit {
  id: number;
  visit: boolean;
  lesson: Lesson;
  student: Account;

  constructor() {
    this.lesson = new Lesson();
    this.student = new Account();
  }


  static clone(stl: Visit): Visit {
    let cloned: Visit = new Visit();
    cloned.id = stl.id;
    cloned.visit = stl.visit;
    cloned.lesson = stl.lesson;
    cloned.student = stl.student;
    return cloned;
  }
}
