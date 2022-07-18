package com.example.week5springhwk.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Orders {//주문

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID", nullable= false)
    private Restaurant restaurant;

    private Orders(Restaurant restaurant){
        this.restaurant=restaurant;
    }

}
