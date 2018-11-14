import {Lesson} from "./lesson";
import {Account} from "./account";

export class Group {
  number: number;
  course: number;
  description: string;
  students: Account[];
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
