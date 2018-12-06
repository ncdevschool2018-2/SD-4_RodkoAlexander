import { Pipe, PipeTransform } from '@angular/core';
import {User} from "../../../model/user";
import {Lesson} from "../../../model/lesson";
import {Visit} from "../../../model/visit";

@Pipe({
  name: 'studentsToVisits'
})
export class StudentsToVisitsPipe implements PipeTransform {

  transform(students: User[], lesson?: Lesson): Visit[] {

    let visits: Visit[] = [];

    for(let user of students){
      let vs: Visit = new Visit();
      vs.lesson = Lesson.clone(lesson);
      vs.student = User.clone(user);
      visits.push(vs);
    }
    return visits;
  }

}
