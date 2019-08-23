package com.restaurante.restaurante.menu;

import com.restaurante.restaurante.exception.DishNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class Menu {



    private CountryFood countryFood;
    private List<Dish> dishes;
    private Ingredient drinks;

    public Menu(List<Dish> dishes, Ingredient drinks){
        this.dishes = dishes;
        this.drinks = drinks;
    }

    public List<Dish> mainMenu() {
        return switch (countryFood) {
            case THAI, JAPANESE, CHINESE -> filterByFoodType(List.of(FoodType.FISH));
            case AMERICAN, ARABIAN, BARBECUE_GRILL -> filterByFoodType(List.of(FoodType.MEAT));
            case FAST_FOOD -> filterByFoodType(List.of(FoodType.FISH, FoodType.MEAT, FoodType.VEGAN));
            case INDIAN -> filterByFoodType(List.of(FoodType.MEAT, FoodType.FISH, FoodType.NON_FISH_NON_MEAT));
            case ITALIAN, MEDITERRANEAN -> filterByFoodType(List.of(FoodType.MEAT, FoodType.FISH, FoodType.VEGAN, FoodType.NON_FISH_NON_MEAT));
            case VEGAN -> filterByFoodType(List.of(FoodType.VEGAN, FoodType.NON_FISH_NON_MEAT));
            case MEXICAN -> filterByFoodType(List.of(FoodType.MEAT, FoodType.NON_FISH_NON_MEAT));
            default -> throw new EnumConstantNotPresentException(CountryFood.class, "Value " + countryFood + " not supported");
        };
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
