import {Routes} from "@angular/router";
import {StartComponent} from "./user-interface/start/start.component";
import {ModifyComponent} from "./modify/modify/modify.component";
import {ScheduleComponent} from "./schedule/schedule/schedule.component";
import {LoginComponent} from "./user-interface/login/login.component";

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
    path: 'modify',
    redirectTo: 'modify',
    pathMatch: 'full',
  },
  {
    path: 'modify',
    component: ModifyComponent
  },
  {
    path: 'schedule',
    redirectTo: 'schedule',
    pathMatch: 'full',
  },
  {
    path: 'schedule',
    component: ScheduleComponent
  },
  {
    path: 'login',
    redirectTo: 'login',
    pathMatch: 'full',
  },
  {
    path: 'login',
    component: LoginComponent
  }
];


export class Router {

  static routes(): Routes {
    return routes;
  }
}
