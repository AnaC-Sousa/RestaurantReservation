package com.restaurante.restaurante.controller;

import com.restaurante.restaurante.menu.FoodType;
import com.restaurante.restaurante.menu.Ingredient;
import com.restaurante.restaurante.repository.IngredientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

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
    public Stream<Ingredient> replaceIngredientAndFoodType(@RequestParam FoodType foodType, @RequestParam String name){
        return ingredientRepository.findByName(name).stream().
                map(ingredient ->{
            ingredient.setName(name);
            ingredient.setFoodType(foodType);
            return ingredientRepository.save(ingredient);
        });

    }

    @PutMapping("/ingredients/{drinkType}/{name}")
    public Stream<Ingredient> replaceIngredientAndDrinkType(@RequestParam Ingredient.SoftDrinks softDrinks, @RequestParam String name){
        return ingredientRepository.findByName(name).stream().
                map(ingredient ->{
                    ingredient.setName(name);
                    ingredient.setDrinks(softDrinks);
                    return ingredientRepository.save(ingredient);
                });
    }

    @DeleteMapping("/ingredients/{id}")
    public void deleteIngredient(@PathVariable int id){
        ingredientRepository.deleteById(id);
    }

}
