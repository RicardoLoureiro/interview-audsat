package com.audsat.interview.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {
    private Long id;
    private String model;
    private String manufacturer;
    private int year;
    private float fipe_value;
}
