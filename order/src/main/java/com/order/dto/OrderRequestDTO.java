package com.order.dto;

import lombok.Data;

@Data
public class OrderRequestDTO {

	private Long id;
	private String customerName;
	private String productName;
	private int quantity;
	private double price;

}
