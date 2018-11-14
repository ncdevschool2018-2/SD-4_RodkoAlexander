import {Routes} from "@angular/router";
import {StartComponent} from "./user-interface/start/start.component";
import {AccountComponent} from "./modify/table/account/account.component";
import {GroupComponent} from "./modify/table/group/group.component";
import {LessonComponent} from "./modify/table/lesson/lesson.component";

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
