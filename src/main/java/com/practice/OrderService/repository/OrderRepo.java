package com.practice.OrderService.repository;

import com.practice.OrderService.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends
        MongoRepository<Order,Integer>
{

}

