package com.restaurante.restaurante.controller;

import com.restaurante.restaurante.menu.FoodType;
import com.restaurante.restaurante.menu.Ingredient;
import com.restaurante.restaurante.service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    @RequestMapping("/ingredients")
    public List<Ingredient> getIngredients(){
        return ingredientService.getIngredients();
    }

    @GetMapping("/ingredients/{name}")
    public List<Ingredient> getIngredientsByName(@RequestParam String name){
        return ingredientService.getIngredientByName(name);
    }

    @PostMapping("/ingredients")
    public Ingredient addIngredient(@RequestBody Ingredient newIngredient){
        return ingredientService.newIngredient(newIngredient);
    }

    @PutMapping("/ingredients/{foodType}/{name}")
    public Stream<Ingredient> replaceIngredientAndFood(@RequestParam FoodType foodType, @RequestParam String name){
        return ingredientService.replaceIngredientAndFoodType(foodType, name);
    }

    @PutMapping("/ingredients/{drinkType}/{name}")
    public Stream<Ingredient> replaceIngredientAndDrinkType(@RequestParam Ingredient.SoftDrinks softDrinks, @RequestParam String name){
        return ingredientService.replaceIngredientAndDrinkType(softDrinks, name);
    }

    @DeleteMapping("/ingredients/{id}")
    public void deleteIngredient(@PathVariable int id){
        ingredientService.deleteIngredient(id);
    }

}
