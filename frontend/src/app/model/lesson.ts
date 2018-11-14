import {Group} from "./group";
import {Account} from "./account";

export class Lesson {
  id: number;
  timeStart: Date;
  timeEnd: Date;
  description: string;
  room: string;
  type: string;
  teacher: Account;
  groups: Group[];

  constructor(){
    this.teacher = new Account();
    this.timeStart = new Date();
    this.timeEnd = new Date();
    this.groups = [];
  }
  static clone(lesson: Lesson): Lesson{
    let cloned: Lesson = new Lesson();
    cloned.id = lesson.id;
    cloned.timeStart = lesson.timeStart;
    cloned.timeEnd = lesson.timeEnd;
    cloned.description = lesson.description;
    cloned.room = lesson.room;
    cloned.type = lesson.type;
    cloned.teacher = lesson.teacher;
    return cloned;
  }
}
