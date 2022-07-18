package com.example.week5springhwk.model;

import com.example.week5springhwk.dto.FoodDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Food {//음식
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID", nullable = false)
    private Restaurant restaurant;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    public Food(Restaurant restaurant, FoodDto foodDto){
        this.restaurant=restaurant;
        this.name=foodDto.getName();
        this.price=foodDto.getPrice();
    }

}
