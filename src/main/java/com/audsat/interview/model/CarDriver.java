package com.audsat.interview.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn(name = "driver_id")
    Driver driver;

    @ManyToOne
    @JoinColumn(name = "car_id")
    Car car;

    private boolean is_main_driver;
}

