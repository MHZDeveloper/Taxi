import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CarService} from "../service/CarService";

@Component({
  selector: 'app-delete-car-form',
  templateUrl: './delete-car-form.component.html',
  styleUrls: ['./delete-car-form.component.css']
})
export class DeleteCarFormComponent implements OnInit {

  carForm : FormGroup;

  constructor(private carService: CarService,
              private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    this.carForm = this.formBuilder.group({
      carNumber: ['', Validators.required]
    });
  }

  onDelete(){
    this.carService.deleteCar(this.carForm.value.carNumber);
    this.carForm.reset();
  }

}
