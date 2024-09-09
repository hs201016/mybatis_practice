package com.example.dev_coffee.service;

import com.example.dev_coffee.dto.OrderDTO;
import com.example.dev_coffee.entity.Order;
import com.example.dev_coffee.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public void addOrder(Order order) {
        orderMapper.insertOrder(order);
    }


    public List<Order> getAllOrders() {
        return orderMapper.selectAllOrders();
    }

    @Transactional
    public OrderDTO updateOrder(OrderDTO orderDTO){
        orderMapper.updateOrder(orderDTO);
        return orderDTO;
    }

    public void deleteOrder(byte[] orderId) {
        orderMapper.deleteOrder(orderId);
    }
}

