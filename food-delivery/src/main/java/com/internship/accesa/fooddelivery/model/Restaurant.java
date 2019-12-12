package com.internship.accesa.fooddelivery.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity(name="restaurant")
public class Restaurant {


    @Id
    private long id;

    private String name;
 /*   @NotNull
    private Dish dish;*/

}
