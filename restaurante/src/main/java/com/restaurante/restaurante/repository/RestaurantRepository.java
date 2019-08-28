package com.restaurante.restaurante.repository;

import com.restaurante.restaurante.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
}
