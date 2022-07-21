package com.example.week5springhwk.repository;

import com.example.week5springhwk.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository <Menu, Long> {
    Menu findByRestaurantId(Long restaurantId);
}
