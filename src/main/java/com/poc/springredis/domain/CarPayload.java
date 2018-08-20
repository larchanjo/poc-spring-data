package com.poc.springredis.domain;

import java.io.Serializable;
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

  private String model;
  private Integer year;

}