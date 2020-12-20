package com.poc.springredis.controllers;

import com.poc.springredis.domain.Car;
import com.poc.springredis.domain.CarService;
import com.poc.springredis.domain.CarType;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(CarType.class, new CarTypePropertyEditorSupport());
  }

  @GetMapping
  public Iterable<Car> get(
      @RequestParam(required = false) CarType type,
      @RequestParam(required = false) String model,
      @RequestParam(required = false) Integer year
  ) {
    log.info("Received get request");

    ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll().withIgnoreNullValues();
    Car car = Car.builder().model(model).year(year).type(type).build();
    Example<Car> carExample = Example.of(car, exampleMatcher);

    return carService.getAll(carExample);
  }

  @GetMapping("/{id}")
  public Car getById(@PathVariable String id) {
    log.info("Received get request");
    return carService.getById(id).get();
  }

  @PostMapping
  public Car post(@RequestBody @Valid CarPayload request) {
    log.info("Received post request {}", request);
    final Car car = request.toCar();
    return carService.save(car);
  }

  @PutMapping("/{id}")
  public Car put(@PathVariable String id, @RequestBody CarPayload request) {
    log.info("Received put request {}", request);
    Car car = request.toCar();
    return carService.update(car);
  }

  @DeleteMapping("/{id}")
  public Car delete(@PathVariable String id) {
    log.info("Received delete request {}", id);
    return carService.delete(id);
  }

}