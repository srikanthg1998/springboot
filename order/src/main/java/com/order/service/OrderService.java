package com.order.service;

import java.util.List;

import com.order.entity.Order;

public interface OrderService {

	Order createOrder(Order order);

	Order getOrderById(Long id);

	List<Order> getAllOrders();

	Order updateOrder(Long id, Order order);

	void deleteOrder(Long id);
}
