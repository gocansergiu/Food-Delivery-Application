package com.internship.accesa.fooddelivery.model;

import java.sql.Timestamp;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
@Data
@Entity
public class Order {
    @Id
    private long id;
    private long id_user;
    private long id_restaurant;
    private Timestamp time;
}
