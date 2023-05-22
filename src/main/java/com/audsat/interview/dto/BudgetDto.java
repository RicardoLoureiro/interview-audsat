package com.audsat.interview.dto;

import com.audsat.interview.model.Car;
import com.audsat.interview.model.Costumer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BudgetDto {
    private Long id;

    private Costumer costumer;

    private Car car;

    private float value_budget;
    private String validate_time;
    private boolean driver_sinister;
    private boolean car_sinister;
}
