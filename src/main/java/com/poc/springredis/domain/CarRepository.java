package com.poc.springredis.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Luram Archanjo / 20180820
 */
@Repository
public interface CarRepository extends JpaRepository<Car, String> {

}