import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HeaderComponent} from "./header/header.component";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {CarouselModule, WavesModule} from "angular-bootstrap-md";
import {StartComponent} from "./start/start.component";

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    FormsModule,
    CarouselModule.forRoot(),
    WavesModule.forRoot(),
  ],
  exports: [HeaderComponent,StartComponent],
  declarations: [HeaderComponent,StartComponent]
})
export class UserInterfaceModule {
}
