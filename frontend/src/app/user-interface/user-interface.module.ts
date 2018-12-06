import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HeaderComponent} from "./header/header.component";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {CarouselModule, WavesModule} from "angular-bootstrap-md";
import {StartComponent} from "./start/start.component";
import {LoginComponent} from './login/login.component';
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {AngularFontAwesomeModule} from "angular-font-awesome";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {NgSelectModule} from "@ng-select/ng-select";

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    FormsModule,
    NgbModule,
    NgSelectModule,
    CarouselModule.forRoot(),
    WavesModule.forRoot(),
    Ng4LoadingSpinnerModule.forRoot(),
    AngularFontAwesomeModule,
  ],
  exports: [HeaderComponent, StartComponent],
  declarations: [HeaderComponent, StartComponent, LoginComponent]
})
export class UserInterfaceModule {
}
