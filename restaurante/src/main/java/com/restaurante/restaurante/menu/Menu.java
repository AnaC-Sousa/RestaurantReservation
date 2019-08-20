package com.restaurante.restaurante.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Menu {

    private CountryFood countryFood;
    private List<Item> items = new ArrayList<>();

    public List<Item> mainMenu() {
        return switch (countryFood) {
            case THAI, JAPANESE, CHINESE -> filterByFoodType(List.of(FoodType.FISH));
            case AMERICAN, ARABIAN, BARBECUE_GRILL -> filterByFoodType(List.of(FoodType.MEAT));
            case FAST_FOOD -> filterByFoodType(List.of(FoodType.FISH, FoodType.MEAT, FoodType.VEGAN));
            case INDIAN -> filterByFoodType(List.of(FoodType.MEAT, FoodType.FISH, FoodType.NON_FISH_NON_MEAT));
            case ITALIAN, MEDITERRANEAN -> filterByFoodType(List.of(FoodType.MEAT, FoodType.FISH, FoodType.VEGAN, FoodType.NON_FISH_NON_MEAT));
            case VEGAN -> filterByFoodType(List.of(FoodType.VEGAN, FoodType.NON_FISH_NON_MEAT));
            default -> throw new EnumConstantNotPresentException(CountryFood.class, "Value " + countryFood + " not supported");
        };
    }

    private List<Item> filterByFoodType(List<FoodType> foodTypes){
        return items.stream().filter(item -> foodTypes.contains(item.getFoodType())).collect(Collectors.toList());
    }

    private void addItem(Item item){
        items.add(item);
    }

    public int getTotalPrice(){
        return items.stream().mapToInt(Item::getUnitPrice).sum();

    }

    public String displayMenu(){
        return items.stream().map(Item::getDescription).reduce("", (description1, description2) -> description1+description2);
    }

}
