import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {RouterModule} from '@angular/router';
import {Router} from "./router";
import {ConnectModule} from "./connect/connect.module";
import {ModifyModule} from "./modify/modify.module";
import {UserInterfaceModule} from "./user-interface/user-interface.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    RouterModule.forRoot(Router.routes()),
    UserInterfaceModule,
    BrowserModule,
    ConnectModule,
    ModifyModule,
  ],
  entryComponents: [],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {

}
