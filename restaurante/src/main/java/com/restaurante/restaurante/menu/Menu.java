package com.restaurante.restaurante.menu;

import com.restaurante.restaurante.exception.DishNotFoundException;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Menu {


    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private CountryFood countryFood;

    @Column(name = "DISHES")
    private List<Dish> dishes;
    private Ingredient drinks;

    public Menu(Long id, List<Dish> dishes, Ingredient drinks){
        this.id = id;
        this.dishes = dishes;
        this.drinks = drinks;
    }

    public List<Dish> mainMenu() {
        switch (countryFood) {
            case THAI:
            case JAPANESE:
            case CHINESE:
                return filterByFoodType(List.of(FoodType.FISH));
            case AMERICAN:
            case ARABIAN:
            case BARBECUE_GRILL:
                return filterByFoodType(List.of(FoodType.MEAT));
            case FAST_FOOD:
                return filterByFoodType(List.of(FoodType.FISH, FoodType.MEAT, FoodType.VEGAN));
            case INDIAN:
                return filterByFoodType(List.of(FoodType.MEAT, FoodType.FISH, FoodType.NON_FISH_NON_MEAT));
            case ITALIAN:
            case MEDITERRANEAN:
                return filterByFoodType(List.of(FoodType.MEAT, FoodType.FISH, FoodType.VEGAN, FoodType.NON_FISH_NON_MEAT));
            case VEGAN:
                return filterByFoodType(List.of(FoodType.VEGAN, FoodType.NON_FISH_NON_MEAT));
            case MEXICAN:
                return filterByFoodType(List.of(FoodType.MEAT, FoodType.NON_FISH_NON_MEAT));
            default:
                throw new EnumConstantNotPresentException(CountryFood.class, "Value " + countryFood + " not supported");
        }
    }

    private List<Dish> filterByFoodType(List<FoodType> foodTypes){
        return dishes.stream().filter(dishes -> foodTypes.contains(dishes.getFoodType())).collect(Collectors.toList());
    }

    private void addDish(Dish dish){
        dishes.add(dish);
    }

    private void addDrinkToMenu(Dish dish, Ingredient drinks) throws DishNotFoundException {
        if(dishes.contains(dish)){
            dish.addIngredientsToDish(drinks);
        }else {
            //crio o prato ou mando excecao
            throw new DishNotFoundException("Cannot add the following drink: " + drinks + ". Dish not found.");
        }
    }

    public int getTotalPrice(){
        return dishes.stream().mapToInt(Dish::getDishPrice).sum();

    }

    public String displayMenu(){
        return dishes.stream().map(dishes -> dishes.getDescription()).reduce("", (description1, description2) -> description1+description2);
    }

}
