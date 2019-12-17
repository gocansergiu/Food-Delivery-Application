package com.internship.accesa.fooddelivery.repository;

import com.internship.accesa.fooddelivery.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    @Query(
            value = "SELECT * FROM dishes WHERE id_restaurant=2",
            nativeQuery = true)
     List<Dish> findByid_restaurant();


}