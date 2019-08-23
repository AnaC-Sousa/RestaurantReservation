package com.restaurante.restaurante.menu;

import java.util.List;

public class Dish {
    private long id;
    private String description;
    private List<Ingredient> plates;
    private FoodType foodType;



    private Dish(long id, String description, List<Ingredient> plates,FoodType foodType) {
        this.id = id;
        this.description = description;
        this.plates = plates;
        this.foodType = foodType;
    }

    public Dish createDish(long id, String description, List<Ingredient> plate, FoodType foodType){
        return new Dish(id, description, plate, foodType);
    }
    public void addIngredientsToDish(Ingredient ingredient){
        plates.add(ingredient);
    }


    public FoodType getFoodType(){
        return this.foodType;
    }

    public String getDescription(){
        return this.description;
    }

    public int getDishPrice(){
        return plates.stream().mapToInt(Ingredient::getUnitPrice).sum();
    }


}
