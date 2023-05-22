package com.audsat.interview.dto;

import com.audsat.interview.model.Car;
import com.audsat.interview.model.Driver;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BudgetDto {
    private Long id;

    private Driver driver;

    private Car car;

    private float value_budget;
    private String expiration;
    private boolean driver_sinister;
    private boolean car_sinister;
}
