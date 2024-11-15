package com.practice.OrderService.controller;

import com.practice.OrderService.dto.OrderDTO;
import com.practice.OrderService.dto.OrderDTOFromFE;
import com.practice.OrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/saveorder")
    public ResponseEntity<OrderDTO> saveorder
            (@RequestBody OrderDTOFromFE orderDTOFromFE)
    {
        OrderDTO orderSavedInDb=
                orderService.saveorderdetails(orderDTOFromFE);
        return new ResponseEntity<>
                (orderSavedInDb, HttpStatus.CREATED);
    }
}
