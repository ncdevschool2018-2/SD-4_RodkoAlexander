import { Pipe, PipeTransform } from '@angular/core';
import {Lesson} from "../../../model/lesson";
import {CalendarEvent} from '../../../../../node_modules/angular-calendar';


const colors: any = {
  red: {
    primary: '#ff3131',
    secondary: '#FAE3E3'
  },
  blue: {
    primary: '#1e90ff',
    secondary: '#D1E8FF'
  },
  yellow: {
    primary: '#5eff00',
    secondary: '#bffdb4'
  }
};


@Pipe({
  name: 'lessonsToCalendarEvents'
})
export class LessonsToCalendarEventsPipe implements PipeTransform {

  transform(value: Lesson[], args?: any): any {
    let events: CalendarEvent[] = [];
    for (let lesson of value) {
      let event : CalendarEvent = {
        id: lesson.id,
        start: new Date(lesson.timeStart),
        end: new Date(lesson.timeEnd),
        title: this.title(lesson),
        color: this.color(lesson.type),


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
      return colors.blue;
  }

  spacer: string = " ";
  room: string = " room: ";
  teacher: string = " teacher: ";

  title(lesson: Lesson){
    return  lesson.subject.abbreviation + this.room + lesson.room + this.teacher + lesson.teacher.firstName + this.spacer + lesson.teacher.lastName;
  }

}
