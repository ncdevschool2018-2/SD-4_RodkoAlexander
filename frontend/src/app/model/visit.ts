import {Lesson} from "./lesson";
import {User} from "./user";

export class Visit {
  id: number;
  visit: boolean;
  lesson: Lesson;
  student: User;

  constructor() {
    this.lesson = new Lesson();
    this.student = new User();
    this.visit = true;
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
