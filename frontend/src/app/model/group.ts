import {Lesson} from "./lesson";
import {User} from "./user";

export class Group {
  id: number;
  course: number;
  description: string;
  students: User[];
  lessons: Lesson[];

  constructor() {
    this.students = [];
    this.lessons = [];
  }


  static clone(group: Group): Group {
    let cloned: Group = new Group();
    cloned.id = group.id;
    cloned.course = group.course;
    cloned.description = group.description;
    return cloned;
  }

}
