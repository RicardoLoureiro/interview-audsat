package com.audsat.interview.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BudgetDto {
    private Long id;

    private String name;
    private String document;
    private String birthdate;

    private String value_budget;

    private String car_model;
    private int car_year;

    private String validate_time;
    private boolean driver_sinister;
    private boolean car_sinister;
}
