package com.audsat.interview.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "costumers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max=100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    Driver driver;
}
