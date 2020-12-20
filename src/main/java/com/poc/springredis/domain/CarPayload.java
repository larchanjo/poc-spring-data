package com.poc.springredis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

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

}