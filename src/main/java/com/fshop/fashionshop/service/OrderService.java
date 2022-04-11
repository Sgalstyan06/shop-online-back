package com.fshop.fashionshop.service;

import com.fshop.fashionshop.model.Order;
import com.fshop.fashionshop.model.commons.enums.OrderStatus;

import java.util.List;

public interface OrderService {

    Order create(Order order);

    List<Order> getAllById(String id);

    List<Order> getAll();

    List<Order> getOrderByStatus(String userId, OrderStatus orderStatus);

    void changeStatus(Long orderId, OrderStatus orderStatus);

    void delete(Long id);
}
