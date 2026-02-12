package com.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.order.dto.OrderRequestDTO;
import com.order.dto.OrderResponseDTO;
import com.order.entity.Order;
import com.order.repo.OrderRepository;
import com.order.utility.ConversionDTOS;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;

	private final ConversionDTOS conversionDTOS;

	public OrderServiceImpl(OrderRepository orderRepository, ConversionDTOS conversionDTOS) {
		this.orderRepository = orderRepository;
		this.conversionDTOS = conversionDTOS;
	}

	@Override
	public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
		Order mapToEntity = this.conversionDTOS.mapToEntity(orderRequestDTO);
		Order saveOrder = orderRepository.save(mapToEntity);
		OrderResponseDTO mapToResponseDTO = this.conversionDTOS.mapToResponseDTO(saveOrder);
		return mapToResponseDTO;

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
