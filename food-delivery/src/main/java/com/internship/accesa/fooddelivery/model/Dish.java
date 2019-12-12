package com.internship.accesa.fooddelivery.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "dish_name")
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;

}
