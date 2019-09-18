package com.restaurante.restaurante.service;

import com.restaurante.restaurante.domain.menu.FoodType;
import com.restaurante.restaurante.domain.menu.Ingredient;
import com.restaurante.restaurante.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public IngredientService() {
    }


    public List<Ingredient> getIngredients(){
        return ingredientRepository.findAll();
    }


    public List<Ingredient> getIngredientByName(String name){
        return ingredientRepository.findByName(name);
    }

    public Ingredient newIngredient(Ingredient newIngredient){
        return ingredientRepository.save(newIngredient);
    }


    public Stream<Ingredient> replaceIngredientAndFoodType(@RequestParam FoodType foodType, @RequestParam String name){
        return ingredientRepository.findByName(name).stream().
                map(ingredient ->{
                    ingredient.setName(name);
                    ingredient.setFoodType(foodType);
                    return ingredientRepository.save(ingredient);
                });

    }


    public Stream<Ingredient> replaceIngredientAndDrinkType(Ingredient.SoftDrinks softDrinks,String name){
        return ingredientRepository.findByName(name).stream().
                map(ingredient ->{
                    ingredient.setName(name);
                    ingredient.setDrinks(softDrinks);
                    return ingredientRepository.save(ingredient);
                });
    }

    public void deleteIngredient(Long id){
        ingredientRepository.deleteById(id);
    }
}
