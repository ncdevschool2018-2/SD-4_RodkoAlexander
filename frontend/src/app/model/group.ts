import {Student} from "./student";
import {Lesson} from "./lesson";

export class Group {
  number: string;
  course: number;
  description: string;
  students: Student[];
  lessons: Lesson[];

  constructor(){
    this.students = [];
    this.lessons = [];
  }


  static clone(group: Group): Group{
    let cloned: Group = new Group();
    cloned.number = group.number;
    cloned.course = group.course;
    cloned.description = group.description;
    return cloned;
  }

}
