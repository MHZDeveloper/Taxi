import {Injectable} from "@angular/core";
import {Subject} from "rxjs";
import {Car} from "../model/Car";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class CarService {

  PATH = 'http://localhost:8080/cars';

  carSubject = new Subject<Car[]>();

  cars: Car[] = [];

  constructor(private httpClient: HttpClient) {
  }

  emitCarSubject() {
    this.carSubject.next(this.cars.slice());
  }


  addCar(car: Car) {
    this.httpClient
      .post(this.PATH, car)
      .subscribe(
        () => {
          this.cars.push(car);
          this.emitCarSubject();
        },
        (error) => {
          alert('fail: ' + error.message);
        }
      );
  }

  deleteCar(carNumber: string) {
    this.httpClient
      .delete(this.PATH + '/' + carNumber)
      .subscribe(
        () => {
          const index = this.cars.findIndex(car => car.carNumber==carNumber);
          this.cars.splice(index,1);
          this.emitCarSubject();
        },
        (error) => {
          alert('fail: ' + error.message);
        }
      );
  }

  getCars() {
    this.httpClient
      .get<any[]>(this.PATH)
      .subscribe(
        (response) => {
          this.cars = response;
          this.emitCarSubject();
        },
        (error) => {
          alert('fail: ' + error.message);
        }
      );
  }

}
