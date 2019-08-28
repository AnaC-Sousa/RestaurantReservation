package com.restaurante.restaurante.controller;

import com.restaurante.restaurante.domain.Restaurant;
import com.restaurante.restaurante.domain.RestaurantRate;
import com.restaurante.restaurante.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants(){
        return restaurantService.all();
    }

    @PostMapping("/restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant newRestaurant){
        return restaurantService.newRestaurant(newRestaurant);
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant getRestaurant(@PathVariable int id){
        return restaurantService.getRestaurantById(id);
    }

    @GetMapping("/restaurants/{id}")
    public int getBill(@PathVariable int id){
        return restaurantService.getBill(id);
    }

    @PutMapping("/restaurants/{id}")
    public Restaurant replaceRestaurant(@RequestBody Restaurant newRestaurant, @PathVariable int id){
        return restaurantService.replaceRestaurant(newRestaurant, id);
    }

    @PutMapping("/restaurants/{id}/{rate}")
    public Restaurant addRate(@RequestBody Restaurant newRestaurant, @PathVariable int id, @RequestParam RestaurantRate rate){
        return restaurantService.addRate(newRestaurant, id, rate);
    }

    @DeleteMapping("/restaurants/{id}")
    public void deleteRestaurant(@PathVariable int id){
        restaurantService.deleteRestaurant(id);
    }

}
