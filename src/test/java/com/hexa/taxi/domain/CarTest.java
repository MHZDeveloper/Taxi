package com.hexa.taxi.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void should_serialize() throws JsonProcessingException {
        //given
        final Car car = new Car(CarNumber.from("12-TUN-4569"), "Bruce Willis");

        //when
        final String serializedCar = new ObjectMapper().writeValueAsString(car);

        //then
        assertThat(serializedCar).isEqualTo("{\"carNumber\":{\"id\":\"12-TUN-4569\"},\"driver\":\"Bruce Willis\"}");
    }

    @Test
    void should_deserialize() throws JsonProcessingException {
        //given
        final String serializedCar = "{\"carNumber\":{\"id\":\"12-TUN-4569\"},\"driver\":\"Bruce Willis\"}";

        //when
        final Car deserializedCar = new ObjectMapper().readValue(serializedCar, Car.class);

        //then
        assertThat(deserializedCar).isEqualToComparingFieldByField(new Car(CarNumber.from("12-TUN-4569"), "Bruce Willis"));
    }

    @Test
    void should_return_true_when_car_has_the_provided_number() {
        assertThat(new Car(CarNumber.from("12-TUN-4569"), "Bruce Willis").hasNumber(CarNumber.from("12-TUN-4569"))).isTrue();
    }

    @Test
    void should_return_false_when_car_has_not_the_provided_number() {
        assertThat(new Car(CarNumber.from("12-TUN-4569"), "Bruce Willis").hasNumber(CarNumber.from("66-TUN-4569"))).isFalse();
    }

}