package com.example.week5springhwk.model;

import com.example.week5springhwk.dto.RestaurantDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
class Restaurant {//식당
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String restaurantName;

    @Column(nullable = false)
    private int minOrderPrice;

    @Column(nullable = false)
    private int deliveryFee;

    public Restaurant(RestaurantDto requestDto) {

    this.restaurantName=requestDto.getName();
    this.minOrderPrice=requestDto.getMinOrderPrice();
    this.deliveryFee=requestDto.getDeliveryFee();
    }
}
