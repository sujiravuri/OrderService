package com.practice.OrderService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private int orderId;
    private List<FoodItemDto> foodItemDtoList;
    private Restaurant restaurant;
    private UserDto userDto;
}
