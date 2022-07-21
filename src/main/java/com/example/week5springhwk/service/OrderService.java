package com.example.week5springhwk.service;

import com.example.week5springhwk.dto.FoodOrderRequestDto;
import com.example.week5springhwk.dto.FoodOrderResponseDto;
import com.example.week5springhwk.dto.OrderRequestDto;
import com.example.week5springhwk.dto.OrderResponseDto;
import com.example.week5springhwk.model.Food;
import com.example.week5springhwk.model.Orders;
import com.example.week5springhwk.model.Restaurant;
import com.example.week5springhwk.repository.FoodRepository;
import com.example.week5springhwk.repository.OrderRepository;
import com.example.week5springhwk.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    public OrderService(OrderRepository orderRepository, FoodRepository foodRepository, RestaurantRepository restaurantRepository){
        this.orderRepository = orderRepository;
        this.foodRepository = foodRepository;
        this.restaurantRepository = restaurantRepository;
    }
    @Transactional
    public OrderResponseDto requestOrder(OrderRequestDto requestDto) {
        Restaurant restaurant = restaurantRepository.findById(requestDto.getRestaurantId())
                .orElseThrow(() -> new IllegalArgumentException("해당 id는 존재하지 않습니다."));
        Orders order = new Orders(restaurant);

        OrderResponseDto orderResponseDto = new OrderResponseDto(restaurant);
        int sum = orderResponseDto.getDeliveryFee();

//        order.setRestaurant(restaurant);
        for(FoodOrderRequestDto foodDto : requestDto.getFoods()){
            if(foodDto.getQuantity() < 1 || foodDto.getQuantity() > 100){
                throw new IllegalArgumentException("주문 가능 수량의 범위는 1 ~ 100 입니다.");
            }
            order.getFoodQuantity().put(foodDto.getId(), foodDto.getQuantity());
            Food food = foodRepository.findById(foodDto.getId())
                    .orElseThrow(() -> new IllegalArgumentException("해당 id는 존재하지 않습니다."));
            order.getFoods().add(food);
            FoodOrderResponseDto foodOrderResponseDto
                    = new FoodOrderResponseDto(food.getName(), foodDto.getQuantity(), foodDto.getQuantity() * food.getPrice());

            orderResponseDto.getFoods().add(foodOrderResponseDto);
            sum += foodOrderResponseDto.getPrice();
        }
        if(sum - orderResponseDto.getDeliveryFee() < restaurant.getMinOrderPrice()){
            throw new IllegalArgumentException("최소 주문 가격을 넘겨 주세요!!");
        }
        orderResponseDto.setTotalPrice(sum);
        orderRepository.save(order);

        return orderResponseDto;
    }

    public List<OrderResponseDto> getOrders() {
        List<Orders> orders = orderRepository.findAll();
        List<OrderResponseDto> orderResponseDtoList = new ArrayList<>();

        for(Orders order : orders){
            OrderResponseDto responseDto = new OrderResponseDto(order);
            int sum = responseDto.getDeliveryFee();
            List<FoodOrderResponseDto> foodOrderResponseDtoList = new ArrayList<>();

            for(Food food : order.getFoods()){
                int quantity = order.getFoodQuantity().get(food.getId());
                FoodOrderResponseDto foodOrderResponseDto
                        = new FoodOrderResponseDto(food.getName(), quantity, quantity * food.getPrice());
                foodOrderResponseDtoList.add(foodOrderResponseDto);
                sum += foodOrderResponseDto.getPrice();
            }
            responseDto.setTotalPrice(sum);
            responseDto.getFoods().addAll(foodOrderResponseDtoList);
            orderResponseDtoList.add(responseDto);
        }
        return orderResponseDtoList;
    }
}