package com.hexa.taxi.controller;

import com.hexa.taxi.controller.dto.CarDto;
import com.hexa.taxi.domain.Car;
import com.hexa.taxi.domain.CarNumber;
import com.hexa.taxi.domain.CarRepository;
import io.restassured.RestAssured;
import io.restassured.mapper.TypeRef;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarRestControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private CarRepository carRepository;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void should_return_cars() {
        carRepository.save(new Car(CarNumber.from("147-TUN-78"), "Bruce Willis"));
        final List<CarDto> cars = when().get("/cars")
                .then()
                .statusCode(200)
                .extract().body().as(new TypeRef<>() {
                });

        assertThat(cars).isNotEmpty();
    }

    @Test
    void should_save_car() {
        assertThat(carRepository.findAll()).isEmpty();

        given()
                .contentType("application/json")
                .body("{\"carNumber\":\"12-TUN-4569\",\"driver\":\"Bruce Willis\"}")
                .when().post("/cars")
                .then()
                .statusCode(200);

        assertThat(carRepository.findAll()).hasSize(1);
    }

    @Test
    void should_fail_saving_car_with_wrong_number() {
        given()
                .contentType("application/json")
                .body("{\"carNumber\":\"12-TUN-z1z2\",\"driver\":\"Bruce Willis\"}")
                .when().post("/cars")
                .then()
                .statusCode(400);

    }

    @Test
    void should_do_nothing_when_deleting_unknown_car_number() {

        when().delete("/cars/12-TUN-415z")
                .then()
                .statusCode(400);

    }
}