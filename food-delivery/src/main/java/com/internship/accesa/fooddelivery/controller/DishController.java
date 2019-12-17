package com.internship.accesa.fooddelivery.controller;

import com.internship.accesa.fooddelivery.model.Dish;
import com.internship.accesa.fooddelivery.model.Restaurant;
import com.internship.accesa.fooddelivery.repository.DishRepository;
import com.internship.accesa.fooddelivery.repository.RestaurantRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Controller
public class DishController {

    private DishRepository repository;

    DishController(DishRepository repository){
        this.repository=repository;
    }



    @GetMapping("dishes")
    @Secured({"ROLE_USER"})
    public ModelAndView getdisheswithRestaurantID(@RequestParam("decisionId") Long decisionId){

        List<Dish> arrayList = repository.findByid_restaurant(decisionId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dishes",arrayList);
        return modelAndView;}

/*    @GetMapping("dishes") // hardcoded all
    @Secured({"ROLE_USER"})
    public ModelAndView allthesmallthings(){
       List<Dish> arrayList = repository.findAll();
       // List<Dish> arrayList = repository.findByid_restaurant();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dishes",arrayList);
        return modelAndView;
    }*/

    }

