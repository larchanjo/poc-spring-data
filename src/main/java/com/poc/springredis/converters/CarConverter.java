package com.poc.springredis.converters;

import com.poc.springredis.domain.Car;
import com.poc.springredis.domain.CarPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @author Luram Archanjo / 20180820
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class CarConverter implements Converter<Car> {

  private CarPayload carPayload;

  @Override
  public Car convert() {
    Car car = null;

    log.info("Converting {} to {}", carPayload, Car.class.getSimpleName());
    if (Objects.nonNull(carPayload)) {
      car = new Car();
      car.setModel(carPayload.getModel());
      car.setYear(carPayload.getYear());
      car.setType(carPayload.getType());
    }

    return car;
  }

}
