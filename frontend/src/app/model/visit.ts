import {Lesson} from "./lesson";
import {Student} from "./student";

export class Visit {
  id: number;
  visit: boolean;
  lesson: Lesson;
  student: Student;

  constructor() {
    this.lesson = new Lesson();
    this.student = new Student();
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
