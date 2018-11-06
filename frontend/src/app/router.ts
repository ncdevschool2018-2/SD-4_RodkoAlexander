import {Routes} from "@angular/router";
import {TeacherComponent} from "./teacher/teacher.component";
import {StartComponent} from "./start/start.component";
import {AccountComponent} from "./account/account.component";
import {StudentComponent} from "./student/student.component";
import {GroupComponent} from "./group/group.component";

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
  }
];


export class Router {

  static routes(): Routes{
    return routes;
  }
}
