package com.internship.accesa.fooddelivery.repository;


import com.internship.accesa.fooddelivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
   // Restaurant findOneById(long id);
}
