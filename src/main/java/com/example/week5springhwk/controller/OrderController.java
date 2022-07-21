package com.example.week5springhwk.controller;

import com.example.week5springhwk.dto.OrderRequestDto;
import com.example.week5springhwk.dto.OrderResponseDto;
import com.example.week5springhwk.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/order/request")
    public OrderResponseDto requestOrder(@RequestBody OrderRequestDto requestDto){
        return orderService.requestOrder(requestDto);
    }

    @GetMapping("/orders")
    public List<OrderResponseDto> getOrders(){
        return orderService.getOrders();
    }
}