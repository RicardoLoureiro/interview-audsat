package com.audsat.interview.dto;

import com.audsat.interview.model.Car;
import com.audsat.interview.model.Costumer;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BudgetFormDto {
    private Long id;

    private String costumer_name;
    private String driver_document;

    private String car_model;
    private String car_year;

    private float value_budget;
    private String validate_time;
    private boolean driver_sinister;
    private boolean car_sinister;
}
