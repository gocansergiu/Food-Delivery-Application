package com.internship.accesa.fooddelivery.repository;

import com.internship.accesa.fooddelivery.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

  @Query(
            value = "SELECT * FROM dishes t WHERE t.id_restaurant = :decisionId",
            nativeQuery = true)
     List<Dish> findByid_restaurant(@Param("decisionId") Long decisionId);

/*@Query(
        value = "SELECT * FROM dishes t WHERE t.id_restaurant = 1",
        nativeQuery = true) //hardcoded
List<Dish> findByid_restaurant();*/

}