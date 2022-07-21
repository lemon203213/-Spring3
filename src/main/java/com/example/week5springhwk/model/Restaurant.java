package com.example.week5springhwk.model;

import com.example.week5springhwk.dto.RestaurantDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public
class Restaurant {//식당
    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String name;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private int minOrderPrice;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private int deliveryFee;

    public Restaurant(RestaurantDto restaurantDto){
        this.name = restaurantDto.getName();
        this.minOrderPrice = restaurantDto.getMinOrderPrice();
        this.deliveryFee = restaurantDto.getDeliveryFee();
    }
}
