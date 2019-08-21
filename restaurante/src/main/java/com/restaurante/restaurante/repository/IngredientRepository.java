package com.restaurante.restaurante.repository;

import com.restaurante.restaurante.menu.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {

    List<Ingredient> findByName(String name);
}
