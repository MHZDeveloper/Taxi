package com.hexa.taxi.service;

import com.hexa.taxi.domain.Car;
import com.hexa.taxi.domain.CarNumber;
import com.hexa.taxi.domain.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public void addCar(@RequestBody final Car car) {
        carRepository.save(car);
    }

    public void delete(@PathVariable final CarNumber carNumber) {
        carRepository.deleteById(carNumber);
    }
}
