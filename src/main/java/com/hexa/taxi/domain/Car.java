package com.hexa.taxi.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {

    private final CarNumber carNumber;
    private final String driver;

    public Car(final CarNumber carNumber,
               final String driver) {
        this.carNumber = carNumber;
        this.driver = driver;
    }

    public boolean hasNumber(final CarNumber carNumber) {
        return this.carNumber.equals(carNumber);
    }

    public CarNumber getCarNumber() {
        return carNumber;
    }

    public String getDriver() {
        return driver;
    }
}
