package com.restaurante.restaurante.menu;

import java.util.List;

public class Dish {
    private long id;
    private String description;
    private List<Ingredient> dish;
    private FoodType foodType;
    private int dishPrice;



    private Dish(long id, String description, List<Ingredient> dish, FoodType foodType) {
        this.id = id;
        this.description = description;
        this.dish = dish;
        this.foodType = foodType;
    }

    public Dish createDish(long id, String description, List<Ingredient> dish){
        return new Dish(id, description, dish, foodType);
    }
    public void addIngredientsToDish(Ingredient ingredient){
        dish.add(ingredient);
    }
    public void addDrinkToDish(Ingredient.SoftDrinks drinks){
        dish.add(drinks);
    }

    public FoodType getFoodType(){
        return this.foodType;
    }

    public String getDescription(){
        return this.description;
    }

    public int getDishPrice(){
        return dish.stream().mapToInt(Ingredient::getUnitPrice).sum();
    }


}
