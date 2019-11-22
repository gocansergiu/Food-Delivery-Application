package com.internship.accesa.fooddelivery.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class OrderDishes {


    @NotNull
    @ManyToOne
    @JoinColumn(name="Order_id")
    private long id_order;


    @NotNull
    @ManyToOne
    @JoinColumn(name="Dish_id")
    private long id_dish;

}
