package com.audsat.interview.repository;

import com.audsat.interview.model.CarDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDriverRepository extends JpaRepository<CarDriver, Long> {
    CarDriver findByCarAndDriver(Long car_id, Long driver_id);
}
