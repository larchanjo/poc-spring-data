package com.poc.springredis.domain;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}