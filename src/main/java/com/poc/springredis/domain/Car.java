package com.poc.springredis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Luram Archanjo / 20180820
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car implements Serializable {

  @Id
  private final String id = UUID.randomUUID().toString();

  @Column
  private String model;

  @Column
  private Integer year;

  @Enumerated(EnumType.STRING)
  private CarType type;

}