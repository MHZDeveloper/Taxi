package com.hexa.taxi.controller.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hexa.taxi.domain.Car;
import com.hexa.taxi.domain.CarNumber;

public class CarDto {

    @JsonProperty("carNumber")
    private final String carNumber;
    @JsonProperty("driver")
    private final String driver;

    @JsonCreator
    public CarDto(@JsonProperty("carNumber") String carNumber,
                  @JsonProperty("driver") String driver) {
        this.carNumber = carNumber;
        this.driver = driver;
    }

    public Car toCar(){
        return new Car(CarNumber.from(carNumber),driver);
    }

    public static CarDto toCarDto(Car car){
        return new CarDto(car.getCarNumber().toString(),car.getDriver());
    }
}
