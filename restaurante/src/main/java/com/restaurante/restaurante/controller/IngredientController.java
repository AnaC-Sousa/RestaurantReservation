package com.restaurante.restaurante.controller;

import com.restaurante.restaurante.menu.FoodType;
import com.restaurante.restaurante.menu.Ingredient;
import com.restaurante.restaurante.repository.IngredientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {

    private final IngredientRepository ingredientRepository;

    public IngredientController(IngredientRepository ingredient){
        this.ingredientRepository = ingredient;
    }

    @RequestMapping("/ingredients")
    public List<Ingredient> getIngredients(){
        return ingredientRepository.findAll();
    }


    @GetMapping("/ingredients/{name}")
    public List<Ingredient> getIngredientByName(@RequestParam String name){
       return ingredientRepository.findByName(name);
    }

    @PostMapping("/ingredients")
    public void newIngredient(@RequestBody Ingredient newIngredient){
        ingredientRepository.save(newIngredient);
    }

    @PutMapping("/ingredients/{foodType}/{name}")
    public void replaceIngredientAndFoodType(@RequestParam FoodType foodType, @RequestParam String name){
    }

    @PutMapping("/ingredients/{drinkType}/{name}")
    public void replaceIngredientAndDrinkType(@RequestBody Ingredient ingredient, @RequestParam FoodType.SoftDrinks softDrinks, @RequestParam String name){


    }

}
