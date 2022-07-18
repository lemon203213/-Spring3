package com.example.week5springhwk.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {
    private String name;
    private int minOrderPrice;
    private int deliveryFee;
}
