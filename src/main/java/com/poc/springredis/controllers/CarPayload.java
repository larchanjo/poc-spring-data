package com.poc.springredis.controllers;

import com.poc.springredis.domain.Car;
import com.poc.springredis.domain.CarType;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Luram Archanjo / 20180820
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarPayload implements Serializable {

    @NotBlank
    private String model;

    @Positive
    @NotNull
    private Integer year;

    @NotNull
    private CarType type;

    public Car toCar() {
        return Car.builder()
            .model(this.model)
            .year(this.year)
            .type(this.type)
            .build();
    }

}