package com.internship.accesa.fooddelivery.controller;

import com.internship.accesa.fooddelivery.model.Restaurant;
import com.internship.accesa.fooddelivery.repository.RestaurantRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api")
public class RestaurantController {

    private RestaurantRepository repository;

    RestaurantController(RestaurantRepository repository) {
        this.repository = repository;
    }

    /*@GetMapping("/all")
    public List<Restaurant> showAll(Model model) {
        model.addAttribute("restaurant", repository.findAll());
        return repository.findAll();
    }*/

    @GetMapping("/restaurants")
    @Secured({"ROLE_USER"})
    public ModelAndView getAllRestaurants(){
    List<Restaurant> arrayList = repository.findAll();
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("restaurants",arrayList);
    return modelAndView;}

    @GetMapping("/restaurants/find/{decisionId}")
    public Optional<Restaurant> findone(@PathVariable @NotNull @DecimalMin("0") Long decisionId ){
            return repository.findById(decisionId);
    }

    @GetMapping("/restaurants/delete/{decisionId}")
    public void delete(@PathVariable @NotNull @DecimalMin("0") Long decisionId ){
         repository.deleteById(decisionId);

    }

}
