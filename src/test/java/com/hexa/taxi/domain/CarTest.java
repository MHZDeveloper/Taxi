package com.hexa.taxi.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void should_return_true_when_car_has_the_provided_number() {
        assertThat(new Car(CarNumber.from("12-TUN-4569"), "Bruce Willis").hasNumber(CarNumber.from("12-TUN-4569"))).isTrue();
    }

    @Test
    void should_return_false_when_car_has_not_the_provided_number() {
        assertThat(new Car(CarNumber.from("12-TUN-4569"), "Bruce Willis").hasNumber(CarNumber.from("66-TUN-4569"))).isFalse();
    }

}