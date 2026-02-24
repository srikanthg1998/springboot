package com.srikanth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.srikanth.dto.Customer;

@Service
public class KafkaMessageListener {

	Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

//	@KafkaListener(topics = "Topic-Kafka-series-one", groupId = "my-group-1")
//	public void listen1(String message) {
//		logger.info("listen1 :=> Received message: {}", message);
//	}

	@KafkaListener(topics = "customer-topic", groupId = "customer-group")
	public void listen1(Customer customer) {
		System.out.println("Hello from listen1 method is called!!");
		logger.info("listen :=> Received message: {}", customer.toString());
		System.out.println("listen :=> Received message: " + customer.getEmail() + ": " + customer.getName());
	}

	/*
	 * @KafkaListener(topics = "Topic-Kafka-series-one", groupId = "my-group-1")
	 * public void listen2(String message) {
	 * logger.info("listen2 :=> Received message: {}", message); }
	 * 
	 * @KafkaListener(topics = "Topic-Kafka-series-one", groupId = "my-group-1")
	 * public void listen3(String message) {
	 * logger.info("listen3 :=> Received message: {}", message); }
	 * 
	 * @KafkaListener(topics = "Topic-Kafka-series-one", groupId = "my-group-1")
	 * public void listen4(String message) {
	 * logger.info("listen4 :=> Received message: {}", message); }
	 */
}