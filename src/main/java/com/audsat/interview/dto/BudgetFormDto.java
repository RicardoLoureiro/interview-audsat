package com.audsat.interview.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class BudgetFormDto {

    private String name;
    private String document;
    private String birthdate;

    private String model;
    private String manufacturer;
    private int year;
    private float fipe_value;

    private Date claim_event_date;
    private boolean is_main_driver;

    private String expiration;
}
