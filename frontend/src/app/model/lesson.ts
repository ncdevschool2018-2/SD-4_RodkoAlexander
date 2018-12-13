import {Group} from "./group";
import {User} from "./user";

export class Lesson {
  id: number;
  timeStart: Date;
  timeEnd: Date;
  description: string;
  room: string;
  type: string;
  teacher: User;
  groups: Group[];

  constructor() {
    this.teacher = new User();
    this.timeStart = new Date();
    this.timeEnd = new Date();
    this.groups = [];
  }

  static clone(lesson: Lesson): Lesson {
    let cloned: Lesson = new Lesson();
    cloned.id = lesson.id;
    cloned.timeStart = lesson.timeStart;
    cloned.timeEnd = lesson.timeEnd;
    cloned.description = lesson.description;
    cloned.room = lesson.room;
    cloned.type = lesson.type;
    cloned.teacher = lesson.teacher;
    cloned.groups = lesson.groups;
    return cloned;
  }
}
