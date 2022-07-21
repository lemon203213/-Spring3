package com.example.week5springhwk.dto;


import lombok.Data;

@Data
public class RestaurantDto {
    private String name;
    private int minOrderPrice;
    private int deliveryFee;
}
