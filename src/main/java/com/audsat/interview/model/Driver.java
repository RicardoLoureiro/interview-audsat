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

import java.util.Set;

@Entity
@Table(name = "drivers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max=25)
    private String document;

    @NotNull
    @Positive
    private Long birthdate;

    @OneToMany(mappedBy = "driver")
    Set<CarDriver> carDrivers;

    @OneToMany(mappedBy = "driver")
    Set<Costumer> costumer;
}
