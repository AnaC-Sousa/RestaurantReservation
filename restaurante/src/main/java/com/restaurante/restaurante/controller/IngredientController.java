package com.restaurante.restaurante.controller;

import com.restaurante.restaurante.menu.FoodType;
import com.restaurante.restaurante.menu.Ingredient;
import com.restaurante.restaurante.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RequestMapping("/ingredients")
@RestController
public class IngredientController {

    @Autowired
    private  IngredientService ingredientService;

    public IngredientController(){
    }

    @GetMapping
    public List<Ingredient> getIngredients(){
        return ingredientService.getIngredients();
    }

    @GetMapping(path = "{name}")
    public List<Ingredient> getIngredientsByName(@RequestParam String name){
        return ingredientService.getIngredientByName(name);
    }

    @PostMapping
    public Ingredient addIngredient(@RequestBody Ingredient newIngredient){
        return ingredientService.newIngredient(newIngredient);
    }

    @PutMapping(path = "{foodType}/{name}")
    public Stream<Ingredient> replaceIngredientAndFood(@RequestParam FoodType foodType, @RequestParam String name){
        return ingredientService.replaceIngredientAndFoodType(foodType, name);
    }

    @PutMapping(path = "{drinkType}/{name}")
    public Stream<Ingredient> replaceIngredientAndDrinkType(@RequestParam Ingredient.SoftDrinks softDrinks, @RequestParam String name){
        return ingredientService.replaceIngredientAndDrinkType(softDrinks, name);
    }

    @DeleteMapping(path = "{id}")
    public void deleteIngredient(@PathVariable int id){
        ingredientService.deleteIngredient(id);
    }

}
