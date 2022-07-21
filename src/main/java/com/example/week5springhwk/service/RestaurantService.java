package com.example.week5springhwk.service;

import com.example.week5springhwk.dto.RestaurantDto;
import com.example.week5springhwk.model.Menu;
import com.example.week5springhwk.model.Restaurant;
import com.example.week5springhwk.repository.MenuRepository;
import com.example.week5springhwk.repository.RestaurantRepository;
import com.example.week5springhwk.validator.Validator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, MenuRepository menuRepository){
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
    }
    @Transactional
    public Restaurant registerRestaurant(RestaurantDto requestDto) {
//        Restaurant existRestaurant = restaurantRepository.finByName(requestDto.getName()).orElse(null);
//        if(existRestaurant != null){
//            return existRestaurant;
//        }
        // validation check
        Validator.restaurantValidator(requestDto);

        Restaurant restaurant = new Restaurant(requestDto);
        restaurantRepository.save(restaurant);
        Menu menu = new Menu(restaurant);
        menuRepository.save(menu);
        return restaurant;
    }

    public List<Restaurant> getRestaurantList() {
        return restaurantRepository.findAll();
    }
}