import construct = Reflect.construct;

export class TableData {
  lesson: string;
  time: string;
  who: string;
  auditorium: string;
  type: string;


  constructor(lesson: string,
              time: string,
              who: string,
              auditorium: string,
              type: string) {

    this.auditorium = auditorium;
    this.time = time;
    this.type = type;
    this.who = who;
    this.lesson = lesson;
  }
}
