package com.hexa.taxi.controller.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexa.taxi.domain.Car;
import com.hexa.taxi.domain.CarNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    void should_serialize() throws JsonProcessingException {
        //given
        final CarDto carDto = new CarDto("12-TUN-4569", "Bruce Willis");

        //when
        final String serializedCar = new ObjectMapper().writeValueAsString(carDto);

        //then
        assertThat(serializedCar).isEqualTo("{\"carNumber\":\"12-TUN-4569\",\"driver\":\"Bruce Willis\"}");
    }

    @Test
    void should_deserialize() throws JsonProcessingException {
        //given
        final String serializedCarDto = "{\"carNumber\":\"12-TUN-4569\",\"driver\":\"Bruce Willis\"}";

        //when
        final CarDto deserializedCarDto = new ObjectMapper().readValue(serializedCarDto, CarDto.class);

        //then
        assertThat(deserializedCarDto).isEqualToComparingFieldByField(new CarDto("12-TUN-4569", "Bruce Willis"));
    }
}