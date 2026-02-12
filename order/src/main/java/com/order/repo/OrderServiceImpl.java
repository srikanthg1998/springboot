package com.order.repo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.order.entity.Order;
import com.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;

	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order getOrderById(Long id) {
		return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order updateOrder(Long id, Order order) {
		Order existing = getOrderById(id);
		existing.setCustomerName(order.getCustomerName());
		existing.setProductName(order.getProductName());
		existing.setQuantity(order.getQuantity());
		existing.setPrice(order.getPrice());
		return orderRepository.save(existing);
	}

	@Override
	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}
}
