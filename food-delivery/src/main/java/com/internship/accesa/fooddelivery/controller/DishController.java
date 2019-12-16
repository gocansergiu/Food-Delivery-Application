package com.internship.accesa.fooddelivery.controller;

import com.internship.accesa.fooddelivery.model.Dish;
import com.internship.accesa.fooddelivery.model.Restaurant;
import com.internship.accesa.fooddelivery.repository.DishRepository;
import com.internship.accesa.fooddelivery.repository.RestaurantRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
public class DishController {

    private DishRepository repository;
    private RestaurantRepository restaurantRepository;

    DishController(DishRepository repository, RestaurantRepository restaurantRepository){
        this.repository=repository;
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("{decisionId}/dishes/")
    @Secured({"ROLE_USER"})
    public ModelAndView getdisheswithRestaurantID(@PathVariable @NotNull @DecimalMin("0") Long decisionId){
        List<Dish> arrayList = repository.findByidRestaurant(decisionId);
// eror with find by id restaurant
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Dishes",arrayList);
        return modelAndView;}


    }

