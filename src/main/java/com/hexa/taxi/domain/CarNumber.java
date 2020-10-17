package com.hexa.taxi.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarNumber {

    private final String id;

    public CarNumber(final String id) {
        this.id = id;
    }

    public static CarNumber from(final String stringCarNumber) {
        Pattern pattern = Pattern.compile("^[1-9]\\d{0,2}-TUN-\\d{1,4}$");
        Matcher matcher = pattern.matcher(stringCarNumber);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(String.format("invalid number %s", stringCarNumber));
        }
        return new CarNumber(stringCarNumber);
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarNumber carNumber = (CarNumber) o;
        return Objects.equals(id, carNumber.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
