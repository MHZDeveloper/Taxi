import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {CarService} from "./service/CarService";
import {HttpClientModule} from "@angular/common/http";
import {ReactiveFormsModule} from "@angular/forms";
import { AddCarFormComponent } from './add-car-form/add-car-form.component';
import { DeleteCarFormComponent } from './delete-car-form/delete-car-form.component';

@NgModule({
  declarations: [
    AppComponent,
    AddCarFormComponent,
    DeleteCarFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    CarService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
