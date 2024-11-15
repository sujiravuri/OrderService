package com.practice.OrderService.service;


import com.practice.OrderService.dto.OrderDTO;
import com.practice.OrderService.dto.OrderDTOFromFE;
import com.practice.OrderService.dto.UserDto;
import com.practice.OrderService.entity.Order;
import com.practice.OrderService.mapper.OrderMapper;
import com.practice.OrderService.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

    public OrderDTO saveorderdetails
            (OrderDTOFromFE orderDTOFromFE) {
        Integer newOrderId =sequenceGenerator.generateNextOrderId();
        UserDto userDto =fetchOrderDetailsFromUserDto(orderDTOFromFE.getUserID());
        Order ordertobesaved = new Order(newOrderId,
                orderDTOFromFE.getFoodItemDtoList(),
                orderDTOFromFE.getRestaurant(),userDto);
        orderRepo.save(ordertobesaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(ordertobesaved);
    }

    private UserDto fetchOrderDetailsFromUserDto(Integer userID)
    {
      return restTemplate.getForObject
               ("http://UserService/Users/fetchById/"+userID,
                       UserDto.class);
    }
}
