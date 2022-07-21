package com.example.week5springhwk.controller;

import com.example.week5springhwk.dto.RestaurantDto;
import com.example.week5springhwk.model.Restaurant;
import com.example.week5springhwk.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @PostMapping("/restaurant/register")
    public Restaurant registerRestaurant(@RequestBody RestaurantDto requestDto){
        return restaurantService.registerRestaurant(requestDto);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurantList(){
        return restaurantService.getRestaurantList();
    }
}