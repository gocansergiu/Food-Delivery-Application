package com.internship.accesa.fooddelivery.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantController {


    @GetMapping("/restaurants")
    @Secured({"ROLE_USER"})
    public List<String> getAllRestaurants(){
        //DUMMY get all restaurants controller
        return Arrays.asList("One restaurant", "Another restaurant");
    }
}
