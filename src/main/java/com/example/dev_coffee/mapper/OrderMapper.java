package com.example.dev_coffee.mapper;

import com.example.dev_coffee.dto.OrderDTO;
import com.example.dev_coffee.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    void insertOrder(Order order);
    void updateOrder(OrderDTO orderDTO);
    Order selectOrderById(String orderId);
    List<Order> selectAllOrders();
    void deleteOrder(byte[] orderId);
}
