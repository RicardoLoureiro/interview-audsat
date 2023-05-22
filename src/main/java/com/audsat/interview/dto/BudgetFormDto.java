package com.audsat.interview.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BudgetFormDto {
    private Long costumer_id;
    private Long car_id;

    private String validate_time;
    private boolean driver_sinister;
    private boolean car_sinister;
}
