package com.internship.accesa.fooddelivery.model;

import java.sql.Timestamp;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private long id_user;

    @NotNull
//    @ManyToOne
    @JoinColumn(name="Restaurant_id")
    private long id_restaurant;

    @NotNull
    private Timestamp time;
}
