package com.example.order.controller;

import com.example.order.model.Order;
import com.example.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/userId/{userId}")
    public List<Order> GetOrderByUserId(@PathVariable(value = "userId") Long userId){
        return orderService.GetOrderByUserId(userId);
    }

    @PutMapping("/")
    public List<Order> CreateOrders(@RequestBody List<Order> orders){

        return orderService.CreateOrders(orders);
    }

}
