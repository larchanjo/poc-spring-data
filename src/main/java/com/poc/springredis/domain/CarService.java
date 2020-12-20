package com.poc.springredis.domain;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Luram Archanjo / 20180820
 */
@Service
@Slf4j
@AllArgsConstructor
public class CarService {

  private final CarRepository carRepository;

  @Transactional
  public Car save(Car car) {
    log.info("Saving {}", car);
    return carRepository.save(car);
  }

  @Transactional
  public Car update(Car car) {
    log.info("Updating {}", car);
    return carRepository.save(car);
  }

  @Transactional
  public Car delete(String id) {
    log.info("Deleting {}", id);
    Car car = getById(id).get();
    carRepository.delete(car);
    return car;
  }

  @Transactional(readOnly = true)
  public Optional<Car> getById(String id) {
    log.info("Getting {} {}", Car.class.getSimpleName(), id);
    return carRepository.findById(id);
  }

  @Transactional(readOnly = true)
  public Iterable<Car> getAll(Example<Car> carExample) {
    log.info("Getting all {}", Car.class.getSimpleName());
    return carRepository.findAll(carExample);
  }

}
