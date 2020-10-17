package com.hexa.taxi.domain;

import java.util.List;

public interface CarRepository {

    List<Car> findAll();

    void save(Car car);

    void deleteById(CarNumber carNumber);
}
