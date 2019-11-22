package com.internship.accesa.fooddelivery.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantController {


    @GetMapping("/restaurants")
    @PreAuthorize("hasRole('USER')")
    public List<String> getAllRestaurants(){
        //DUMMY get all restaurants controller
        return new ArrayList<>();
    }
}
