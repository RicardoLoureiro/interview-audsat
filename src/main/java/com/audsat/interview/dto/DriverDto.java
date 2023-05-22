package com.audsat.interview.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class DriverDto {
    private Long id;

    private String name;
    private Date birthdate;
    private String document;

    private float value_budget;
}
