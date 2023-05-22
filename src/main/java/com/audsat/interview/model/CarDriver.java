package com.audsat.interview.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "car_drivers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDriver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean is_main_driver;
    private Date claim_event_date;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    @NotNull
    Driver driver;

    @ManyToOne
    @JoinColumn(name = "car_id")
    @NotNull
    Car car;
}

