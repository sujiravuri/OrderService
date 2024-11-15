package com.practice.OrderService.mapper;

import com.practice.OrderService.dto.OrderDTO;
import com.practice.OrderService.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO mapOrderToOrderDTO(Order order);
    Order mapOrderDTOToOrder(OrderDTO orderDTO);
}
