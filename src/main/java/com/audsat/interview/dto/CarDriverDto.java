package com.audsat.interview.dto;

import com.audsat.interview.model.Car;
import com.audsat.interview.model.Driver;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDriverDto {
    private Long id;
    private Driver driver;
    private Car car;
    private boolean is_main_driver;
}
