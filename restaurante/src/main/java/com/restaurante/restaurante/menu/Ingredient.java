package com.restaurante.restaurante.menu;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient {

    public enum SoftDrinks {
        WATER,
        WINE,
        SODA
    }
    private @Id @GeneratedValue Long id;
    @Column(name = "NAME")
    private String name;

    @Enumerated(EnumType.STRING)
    private FoodType foodType;

    @Enumerated(EnumType.STRING)
    private SoftDrinks drinks;
    @Column(name = "UNIT_PRICE")
    private int unitPrice;
    private static List<Ingredient> ingredientList = new ArrayList<>();

    public Ingredient(){}
    private Ingredient(String name, FoodType foodType, int unitPrice) {
        this.name = name;
        this.foodType = foodType;
        this.unitPrice = unitPrice;
    }

    private Ingredient(String name, SoftDrinks softDrinks, int unitPrice) {
        this.name = name;
        this.drinks = softDrinks;
        this.unitPrice = unitPrice;
    }

    private static void createIngredientAndAddToList(String description, FoodType foodType, int unitPrice){
        Ingredient newIngredient = new Ingredient(description, foodType,unitPrice);
        addIngredientToList(newIngredient);
    }

    private static void createDrinkAndAddToList(String description, SoftDrinks softDrinks, int unitPrice){
        Ingredient newIngredient = new Ingredient(description,softDrinks,unitPrice);
        addIngredientToList(newIngredient);
    }

    private static void addIngredientToList(Ingredient newIngredient) {
        ingredientList.add(newIngredient);
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
