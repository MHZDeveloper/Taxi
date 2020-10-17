package com.hexa.taxi.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"12-TUN-19", "12-TUN-1599", "120-TUN-1599"})
    void should_build_car_number_from_String(final String stringCarNumber) {
        //when
        final CarNumber carNumber = CarNumber.from(stringCarNumber);

        //Then
        assertThat(carNumber.toString()).isEqualTo(stringCarNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"120-TUN-1599 d", "120-TUN-1599d", "ddd-TUN-1599",
            "184-DDD-1599", "145-TUN-159d", "", " ", "000-TUN-1599"})
    void should_fail_building_when_invalid_car_number(final String stringCarNumber) {
        assertThatThrownBy(() -> CarNumber.from(stringCarNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}