package com.example.week5springhwk.repository;

import com.example.week5springhwk.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
