package com.internship.accesa.fooddelivery.controller;

import com.internship.accesa.fooddelivery.model.Restaurant;
import com.internship.accesa.fooddelivery.repository.RestaurantRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    private RestaurantRepository repository;

    RestaurantController(RestaurantRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/restaurants")
    @Secured({"ROLE_USER"})
    public List<Restaurant> getAllRestaurants(){
        //DUMMY get all restaurants controller
       // return Arrays.asList("One restaurant", "Another restaurant");
  //      ModelAndView modelAndView = new ModelAndView();
        
     return repository.findAll();


    }

    @GetMapping("/restaurants/find/{decisionId}")
    public Optional<Restaurant> findone(@PathVariable @NotNull @DecimalMin("0") Long decisionId ){
            return repository.findById(decisionId);
    }

    @GetMapping("/restaurants/delete/{decisionId}")
    public void delete(@PathVariable @NotNull @DecimalMin("0") Long decisionId ){
         repository.deleteById(decisionId);

    }
}
