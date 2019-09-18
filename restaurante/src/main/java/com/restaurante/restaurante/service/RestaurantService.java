package com.restaurante.restaurante.service;

import com.restaurante.restaurante.domain.Restaurant;
import com.restaurante.restaurante.domain.RestaurantRate;
import com.restaurante.restaurante.exception.RestaurantNotFoundException;
import com.restaurante.restaurante.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public RestaurantService() {
    }

/*
    public List<Restaurant> all(){
        return restaurantRepository.findAll();
    }


    public Restaurant newRestaurant(Restaurant newRestaurant){
        return restaurantRepository.save(newRestaurant);
    }


    public Restaurant getRestaurantById(Long id){
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));
    }


    public int getBill(int id){
        return restaurantRepository.findById(id).get().getBill();
    }


    public Restaurant replaceRestaurant( Restaurant newRestaurant, int id){
        return restaurantRepository.findById(id)
                .map(restaurant -> {
                    restaurant.setName(newRestaurant.getName());
                    restaurant.setAddress(newRestaurant.getAddress());
                    restaurant.setCountryFood(newRestaurant.getCountryFood());
                    restaurant.setMaxCapacity(newRestaurant.getMaxCapacity());
                    restaurant.setPhoneNumber(newRestaurant.getPhoneNumber());
                    return restaurantRepository.save(restaurant);
                })
                .orElseGet(() -> {
                    newRestaurant.setId(id);
                    return restaurantRepository.save(newRestaurant);
                });
    }


    public Restaurant addRate(Restaurant newRestaurant, int id, RestaurantRate rate){
        return restaurantRepository.findById(id)
                .map(restaurant -> {
                    restaurant.setName(newRestaurant.getName());
                    restaurant.setAddress(newRestaurant.getAddress());
                    restaurant.setCountryFood(newRestaurant.getCountryFood());
                    restaurant.setMaxCapacity(newRestaurant.getMaxCapacity());
                    restaurant.setPhoneNumber(newRestaurant.getPhoneNumber());
                    restaurant.setRate(rate);
                    return restaurantRepository.save(restaurant);
                })
                .orElseGet(() -> {
                    newRestaurant.setId(id);
                    return restaurantRepository.save(newRestaurant);
                });
    }

    public void deleteRestaurant(Long id){
        restaurantRepository.deleteById(id);
    }*/
}
