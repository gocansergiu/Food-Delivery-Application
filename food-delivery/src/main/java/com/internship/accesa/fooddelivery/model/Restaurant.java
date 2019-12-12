package com.internship.accesa.fooddelivery.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "restaurant_name")
    private String restaurantName;

}
