import {Pipe, PipeTransform} from '@angular/core';
import {Lesson} from "../../../model/lesson";
import {CalendarEvent} from 'angular-calendar';

const colors: any = {
  red: {
    primary: '#ad2121',
    secondary: '#ff7776'
  },
  green: {
    primary: '#38ff00',
    secondary: '#80ff7c'
  },
  yellow: {
    primary: '#fff900',
    secondary: '#fbff79'
  }
};

@Pipe({
  name: 'lessonToCalendarEvent'
})
export class LessonToCalendarEventPipe implements PipeTransform {

  transform(value: Lesson[], args?: any): any {
    let events: CalendarEvent[] = [];
    for (let lesson of value) {
      let event = {
        start: new Date(lesson.timeStart),
        end: new Date(lesson.timeEnd),
        title: this.title(lesson),
        color: this.color(lesson.type)
      };
      events.push(event);
    }
    return events;
  }

  color(lessonType: string) {
    if (lessonType == "Laboratory")
      return colors.red;
    if (lessonType == "Practical")
      return colors.yellow;
    if (lessonType == "Lection")
      return colors.green;
  }

  spacer: string = " ";
  room: string = " room: ";
  teacher: string = " teacher: ";

  title(lesson: Lesson){
    return  lesson.description + this.room + lesson.room + this.teacher + lesson.teacher.firstName + this.spacer + lesson.teacher.lastName;
  }
}
