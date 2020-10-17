import {Component, OnDestroy, OnInit} from '@angular/core';
import {CarService} from "./service/CarService";
import {Car} from "./model/Car";
import {Subscription} from "rxjs";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit,OnDestroy{

  title = 'Taxi';
  cars : Car[];
  carSubscription : Subscription;

  constructor(private carService: CarService) {
  }

  ngOnInit() {

    this.carService.getCars();
    this.carSubscription = this.carService.carSubject.subscribe(
      (cars : Car[]) => {
        this.cars=cars;
      }
    )
    this.carService.emitCarSubject();
  }

  ngOnDestroy() {
    this.carService.carSubject.unsubscribe();
  }

}
