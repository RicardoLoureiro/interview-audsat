package com.audsat.interview.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "budgets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private float value_budget;

    @NotBlank
    private String expiration;

    @NotNull
    private boolean car_sinister = false;

    @NotNull
    private boolean driver_sinister = false;

    @ManyToOne
    @NotNull
    private Costumer costumer;

    @ManyToOne
    @NotNull
    private Car car;
}
