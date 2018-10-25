import construct = Reflect.construct;

export class Lesson {
  id: string;
  date: string;
  teacher: string;
  room: string;
  subject: string;
  who: string;
  lessonType: string;
  time: string;


  /*constructor(lesson: string,
              time: string,
              who: string,
              auditorium: string,
              type: string) {

    this.auditorium = auditorium;
    this.time = time;
    this.type = type;
    this.who = who;
    this.lesson = lesson;
  }*/

  constructor(){}

  static clone(lesson: Lesson): Lesson {
    let clone: Lesson = new Lesson();
    clone.id = lesson.id;
    clone.date =  lesson.date;
    clone.teacher =  lesson.teacher;
    clone.room =  lesson.room;
    clone.subject =  lesson.subject;
    clone.who = lesson.who;
    clone.lessonType = lesson.lessonType;
    clone.time = lesson.time;
    return clone;
  }

}
