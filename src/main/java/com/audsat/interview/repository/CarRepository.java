package com.audsat.interview.repository;

import com.audsat.interview.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByModelAndManufacturerAndYear(String model, String manufacturer, int year);
}
