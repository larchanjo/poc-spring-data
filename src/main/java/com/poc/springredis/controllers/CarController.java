package com.poc.springredis.controllers;

import com.poc.springredis.converters.CarConverter;
import com.poc.springredis.domain.Car;
import com.poc.springredis.domain.CarPayload;
import com.poc.springredis.services.CarService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Luram Archanjo / 20180820
 */
@RestController
@RequestMapping("/cars")
@Slf4j
@AllArgsConstructor
public class CarController {

  private final CarService carService;

  @GetMapping
  public Iterable<Car> get() {
    log.info("Received get request");
    return carService.getAll();
  }

  @GetMapping("/{id}")
  public Car getById(@PathVariable String id) {
    log.info("Received get request");
    return carService.getById(id).get();
  }

  @PostMapping
  public Car post(@RequestBody CarPayload carPayload) {
    log.info("Received post request {}", carPayload);

    Car car = CarConverter.builder()
        .carPayload(carPayload)
        .build()
        .convert();

    return carService.save(car);
  }

  @PutMapping("/{id}")
  public Car put(@PathVariable String id, @RequestBody CarPayload carPayload) {
    log.info("Received put request {}", carPayload);

    Car car = CarConverter.builder()
        .carPayload(carPayload)
        .build()
        .convert();

    return carService.update(car);
  }

  @DeleteMapping("/{id}")
  public Car delete(@PathVariable String id) {
    log.info("Received delete request {}", id);
    return carService.delete(id);
  }

}