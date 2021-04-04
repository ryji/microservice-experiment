package com.example.order.services;

import com.example.order.model.Order;

import java.util.List;


public interface OrderService {

    List<Order> GetOrderByUserId(Long userId);
    List<Order> CreateOrders(List<Order> orders);
}
