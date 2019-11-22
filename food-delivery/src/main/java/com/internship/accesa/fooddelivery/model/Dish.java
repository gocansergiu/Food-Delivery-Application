package com.internship.accesa.fooddelivery.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

//    @ManyToOne
    @JoinColumn(name = "Restaurant_id")
    private  long id_restaurant;
}
