package com.example.week5springhwk.model;

import com.example.week5springhwk.dto.FoodDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Food {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @JsonIgnore
    @ManyToOne
    //@JoinColumn(name="MENU_ID") -> 안해줘도 ToOne이기 때문에 자동으로 FK 컬럼이 생성된다.
    private Menu menu;

    public Food(FoodDto foodDto) {
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
        menu.getFoods().add(this);
    }
}
