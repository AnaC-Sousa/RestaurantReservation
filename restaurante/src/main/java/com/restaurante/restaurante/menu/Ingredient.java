package com.restaurante.restaurante.menu;

import javax.persistence.EntityNotFoundException;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class Ingredient {

    public enum SoftDrinks {
        WATER,
        WINE,
        SODA
    }
    private @Id @GeneratedValue Integer id;

    private String name;
    private FoodType foodType;
    private SoftDrinks drinks;
    private int unitPrice;
    private static List<Ingredient> ingredientList = new ArrayList<>();


    private Ingredient(String name, FoodType foodType, int unitPrice) {
        this.name = name;
        this.foodType = foodType;
        this.unitPrice = unitPrice;
    }

    private Ingredient(String name,SoftDrinks softDrinks, int unitPrice) {
        this.name = name;
        this.drinks = softDrinks;
        this.unitPrice = unitPrice;
    }

    private static Ingredient createIngredientAndAddToList(String description, FoodType foodType, int unitPrice){
        Ingredient newIngredient = new Ingredient(description, foodType,unitPrice);
        addIngredientToList(newIngredient);
        return newIngredient;
    }

    private static void addIngredientToList(Ingredient newIngredient) {
        ingredientList.add(newIngredient);
    }

    public FoodType getFoodType(){
        return this.foodType;
    }

    public SoftDrinks getSoftDrinks(){
        return this.drinks;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setFoodType(FoodType foodType){
        this.foodType = foodType;
    }

    public void setDrinks(SoftDrinks drinks){
        this.drinks = drinks;
    }
}
