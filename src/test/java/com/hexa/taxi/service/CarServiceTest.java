package com.hexa.taxi.service;

import com.hexa.taxi.domain.Car;
import com.hexa.taxi.domain.CarNumber;
import com.hexa.taxi.domain.CarRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CarServiceTest {

    private CarRepository carRepository = Mockito.mock(CarRepository.class);
    private CarService carService = new CarService(carRepository);

    @Test
    void should_add_a_car() {
        //given
        Car car = new Car(CarNumber.from("152-TUN-785"), "Bruce Willis");

        //when
        carService.addCar(car);

        //then
        Mockito.verify(carRepository,Mockito.times(1)).save(car);
    }

    @Test
    void should_delete_a_car() {
        //given
        Car car = new Car(CarNumber.from("152-TUN-785"), "Bruce Willis");
        carRepository.save(car);
        //when
        carService.delete(CarNumber.from("152-TUN-785"));

        //then
        Mockito.verify(carRepository,Mockito.times(1)).deleteById(CarNumber.from("152-TUN-785"));
        Assertions.assertThat(carRepository.findAll()).isEmpty();
    }
}