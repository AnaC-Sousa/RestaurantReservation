package com.restaurante.restaurante.controller;

import com.restaurante.restaurante.domain.Restaurant;
import com.restaurante.restaurante.domain.RestaurantRate;
import com.restaurante.restaurante.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/restaurants")
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    public RestaurantController() {

    }

/*
    @GetMapping
    public List<Restaurant> getRestaurants(){
        return restaurantService.all();
    }

    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant newRestaurant){
        return restaurantService.newRestaurant(newRestaurant);
    }

    @GetMapping(path = "{id}")
    public Restaurant getRestaurant(@PathVariable Long id){
        return restaurantService.getRestaurantById(id);
    }

    @GetMapping(path = "{id}")
    public int getBill(@PathVariable Long id){
        return restaurantService.getBill(id);
    }

    @PutMapping(path = "{id}")
    public Restaurant replaceRestaurant(@RequestBody Restaurant newRestaurant, @PathVariable Long id){
        return restaurantService.replaceRestaurant(newRestaurant, id);
    }

    @PutMapping(path = "{id}/{rate}")
    public Restaurant addRate(@RequestBody Restaurant newRestaurant, @PathVariable Long id, @RequestParam RestaurantRate rate){
        return restaurantService.addRate(newRestaurant, id, rate);
    }

    @DeleteMapping(path = "{id}")
    public void deleteRestaurant(@PathVariable Long id){
        restaurantService.deleteRestaurant(id);
    }
*/
}
