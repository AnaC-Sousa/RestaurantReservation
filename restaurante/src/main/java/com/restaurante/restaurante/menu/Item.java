package com.restaurante.restaurante.menu;

public class Item {
    private String description;
    private FoodType foodType;
    private FoodType.SoftDrinks drinks;
    private int unitPrice;

    private Item(String description, FoodType foodType, FoodType.SoftDrinks softDrinks, int unitPrice) {
        this.description = description;
        this.foodType = foodType;
        this.drinks = softDrinks;
        this.unitPrice = unitPrice;
    }

    private static Item createItem(String description, FoodType foodType, FoodType.SoftDrinks drinks, int unitPrice){
        return new Item(description, foodType, drinks, unitPrice);
    }

    public FoodType getFoodType(){
        return this.foodType;
    }

    public FoodType.SoftDrinks getSoftDrinks(){
        return this.drinks;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public String getDescription(){
        return this.description;
    }
}
