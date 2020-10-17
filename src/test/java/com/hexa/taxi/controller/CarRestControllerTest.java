package com.hexa.taxi.controller;

import com.hexa.taxi.TaxiApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;

@SpringBootTest(classes = {TaxiApplication.class, CarRestController.class})
class CarRestControllerTest {



    @Test
    void should_return_correct_value() {
        given()
                .port(8080)
                .baseUri("http://localhost/")
                .basePath("/cars")
                .get()
                .then()
                .statusCode(200)
        .log().ifError();
    }
}