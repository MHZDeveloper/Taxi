import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Car} from "../model/Car";
import {CarService} from "../service/CarService";

@Component({
  selector: 'app-add-car-form',
  templateUrl: './add-car-form.component.html',
  styleUrls: ['./add-car-form.component.css']
})
export class AddCarFormComponent implements OnInit {

  carForm : FormGroup;

  constructor(private carService: CarService,
              private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    this.carForm = this.formBuilder.group({
      carNumber: ['', Validators.required],
      driver: ['', Validators.required]
    });
  }

  onAdd(){
    const formValue = this.carForm.value;
    this.carService.addCar(new Car(formValue.carNumber,formValue.driver));
    this.carForm.reset();
  }

}
