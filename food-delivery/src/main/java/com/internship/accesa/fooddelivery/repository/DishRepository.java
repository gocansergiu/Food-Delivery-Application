package com.internship.accesa.fooddelivery.repository;

import com.internship.accesa.fooddelivery.model.Dish;
import com.internship.accesa.fooddelivery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    //Optional<Dish> findByIDRestaurant(String email);
}