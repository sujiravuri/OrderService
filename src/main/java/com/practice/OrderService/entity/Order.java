package com.practice.OrderService.entity;

import com.practice.OrderService.dto.FoodItemDto;
import com.practice.OrderService.dto.Restaurant;
import com.practice.OrderService.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {

    private int orderId;
    private List<FoodItemDto> foodItemDtoList;
    private Restaurant restaurant;
    private UserDto userDto;
}
