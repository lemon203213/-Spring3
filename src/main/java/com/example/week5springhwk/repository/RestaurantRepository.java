package com.example.week5springhwk.repository;

import com.example.week5springhwk.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository <Restaurant,Long> {
}
