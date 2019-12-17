package com.internship.accesa.fooddelivery.repository;

import com.internship.accesa.fooddelivery.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    //Optional<Dish> findByIDRestaurant(String email);

    @Query(
            value = "SELECT * FROM dishes WHERE id_restaurant=2",
            //countQuery = "SELECT count(*) FROM dishes",
            nativeQuery = true)
     List<Dish> findByid_restaurant();


}