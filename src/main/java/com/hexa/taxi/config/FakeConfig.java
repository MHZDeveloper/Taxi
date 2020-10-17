package com.hexa.taxi.config;

import com.hexa.taxi.domain.Car;
import com.hexa.taxi.domain.CarNumber;
import com.hexa.taxi.domain.CarRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class FakeConfig {

    @Bean
    public CarRepository carRepository() {
        return new CarRepository() {
            private final List<Car> cars = new ArrayList();
            @Override
            public List<Car> findAll() {
                return cars;
            }

            @Override
            public void save(Car car) {
                cars.add(car);
            }

            @Override
            public void deleteById(CarNumber carNumber) {
                cars.removeIf(car -> car.hasNumber(carNumber));
            }
        };
    }
}
