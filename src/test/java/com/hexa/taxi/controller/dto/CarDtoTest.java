package com.hexa.taxi.controller.dto;

import com.hexa.taxi.domain.Car;
import com.hexa.taxi.domain.CarNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarDtoTest {

    @Test
    void should_convert_to_car() {
        //given
        CarDto carDto = new CarDto("145-TUN-785", "Bruce");

        //when
        Car car = carDto.toCar();

        //then
        Assertions.assertThat(car.getCarNumber()).isEqualTo(CarNumber.from("145-TUN-785"));
        Assertions.assertThat(car.getDriver()).isEqualTo("Bruce");
    }

    @Test
    void should_convert_to_carDto() {
        //given
        Car car = new Car(CarNumber.from("145-TUN-785"), "Bruce");

        //when
        CarDto carDto = CarDto.toCarDto(car);

        //then
        Assertions.assertThat(carDto).isEqualToComparingFieldByField(new CarDto("145-TUN-785", "Bruce"));
    }
}