package com.order.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.Order;
import com.order.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	// CREATE
	@PostMapping
	public Order createOrder(@RequestBody Order order) {
		return orderService.createOrder(order);
	}

	// READ BY ID
	@GetMapping("/{id}")
	public Order getOrder(@PathVariable Long id) {
		return orderService.getOrderById(id);
	}

	// READ ALL
	@GetMapping
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	// UPDATE
	@PutMapping("/{id}")
	public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
		return orderService.updateOrder(id, order);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public String deleteOrder(@PathVariable Long id) {
		orderService.deleteOrder(id);
		return "Order deleted successfully";
	}
}
