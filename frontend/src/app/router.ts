import {Routes} from "@angular/router";
import {TeacherComponent} from "./modify/teacher/teacher.component";
import {StartComponent} from "./user-interface/start/start.component";
import {AccountComponent} from "./modify/account/account.component";
import {StudentComponent} from "./modify/student/student.component";
import {GroupComponent} from "./modify/group/group.component";
import {LessonComponent} from "./modify/lesson/lesson.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'start',
    pathMatch: 'full',
  },
  {
    path: 'start',
    component: StartComponent
  },
  {
    path: 'accounts',
    redirectTo: 'accounts',
    pathMatch: 'full',
  },
  {
    path: 'accounts',
    component: AccountComponent
  },
  {
    path: 'teachers',
    redirectTo: 'teachers',
    pathMatch: 'full',
  },
  {
    path: 'teachers',
    component: TeacherComponent
  },
  {
    path: 'students',
    redirectTo: 'students',
    pathMatch: 'full',
  },
  {
    path: 'students',
    component: StudentComponent
  },
  {
    path: 'groups',
    redirectTo: 'groups',
    pathMatch: 'full',
  },
  {
    path: 'groups',
    component: GroupComponent
  },
  {
    path: 'lessons',
    redirectTo: 'lessons',
    pathMatch: 'full',
  },
  {
    path: 'lessons',
    component: LessonComponent
  }
];


export class Router {

  static routes(): Routes{
    return routes;
  }
}
