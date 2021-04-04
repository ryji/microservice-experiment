package com.example.order.services;

import com.example.order.client.RepertoryFeignClient;
import com.example.order.model.Order;
import com.example.order.model.Repertory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    RepertoryFeignClient repertoryClient;

    @Override
    public List<Order> GetOrderByUserId(Long userId) {
        Repertory repertory = repertoryClient.getRepertory(1L);
        Order order = new Order();
        order.setGoodsId(repertory.getGoodsId());
        return Arrays.asList(order);
    }

    @Override
    public List<Order> CreateOrders(List<Order> orders) {
        List<Repertory> repertoryList = repertoryClient.getRepertoryList(Arrays.asList(1L, 2L));

        return repertoryList.stream().map(item -> {
            Order order = new Order();
            order.setGoodsId(item.getGoodsId());
            return order;
        }).collect(Collectors.toList());
    }
}
