package com.hexa.taxi.controller;

import com.hexa.taxi.controller.dto.CarDto;
import com.hexa.taxi.domain.CarNumber;
import com.hexa.taxi.service.CarService;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/cars")
public class CarRestController {

    private final CarService carService;
    private static final Logger logger = LoggerFactory.getLogger(CarRestController.class);

    @Autowired
    public CarRestController(final CarService carService) {
        this.carService=carService;
    }

    @GetMapping
    public List<CarDto> getCars() {
        logger.info("Returning all cars ...");
        return carService.getCars().stream().map(CarDto::toCarDto).collect(Collectors.toList());
    }

    @PostMapping
    public void addCar(@RequestBody final CarDto carDto) {
        carService.addCar(carDto.toCar());
    }

    @DeleteMapping(value = "/{carNumber}")
    public void delete(@PathVariable @ApiParam(example = "166-TUN-758") final String carNumber) {
        carService.delete(CarNumber.from(carNumber));
    }


}
