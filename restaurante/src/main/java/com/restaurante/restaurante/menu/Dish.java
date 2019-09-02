package com.restaurante.restaurante.menu;

import javax.persistence.*;
import java.util.List;

@Entity
public class Dish {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PLATES")
    private List<Ingredient> plates;

    @Enumerated(EnumType.STRING)
    private FoodType foodType;



    private Dish(String description, List<Ingredient> plates,FoodType foodType) {
        this.description = description;
        this.plates = plates;
        this.foodType = foodType;
    }

    public Dish createDish(String description, List<Ingredient> plate, FoodType foodType){
        return new Dish(description, plate, foodType);
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
