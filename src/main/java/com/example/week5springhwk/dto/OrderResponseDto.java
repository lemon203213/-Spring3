package com.example.week5springhwk.dto;

import com.example.week5springhwk.model.Orders;
import com.example.week5springhwk.model.Restaurant;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderResponseDto {
    private String restaurantName;
    List<FoodOrderResponseDto> foods;
    private int deliveryFee;
    private int totalPrice;

    public OrderResponseDto(Orders order){
        this.foods = new ArrayList<>();
        this.restaurantName = order.getRestaurant().getName();
        this.deliveryFee = order.getRestaurant().getDeliveryFee();

    }
    public OrderResponseDto(Restaurant restaurant){
        this.foods = new ArrayList<>();
        this.restaurantName = restaurant.getName();
        this.deliveryFee = restaurant.getDeliveryFee();

    }
}
