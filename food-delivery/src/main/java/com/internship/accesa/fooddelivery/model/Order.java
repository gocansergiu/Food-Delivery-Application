package com.internship.accesa.fooddelivery.model;

import java.sql.Timestamp;
import java.util.ArrayList;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "id_user")
    private Long idUser;

    @Column(name= "creation_date")
    private Timestamp creationDate;

    @NotNull
    @Column(name= "id_restaurant")
    private Long idRestaurant;
}
