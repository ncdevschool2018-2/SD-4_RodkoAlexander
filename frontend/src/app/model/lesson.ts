import {Teacher} from "./teacher";

export class Lesson {
  id: number;
  timeStart: Date;
  timeEnd: Date;
  description: string;
  room: string;
  type: string;
  teacher: Teacher;
  constructor(){
    this.teacher = new Teacher();
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
