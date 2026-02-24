package com.srikanth.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.srikanth.dto.Customer;

@Service
public class KafkaMessagePublisher {

	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;

//	private String topic = "Topic-Kafka-one";
//	private String topic = "Topic-Kafka-series-one";
	private static final String topic = "Topic-Kafka-Customer";

//	public void sendMessage(String message) {
//		CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, message);
//		try {
//			future.whenComplete((result, ex) -> {
//				if (ex == null) {
//					System.out.println("Send message [" + message + result.getRecordMetadata().offset() + " ]");
//				} else {
//					System.out.println("Unable to send the message " + ex.getMessage());
//				}
//			});
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public void sendEventMessage(Customer customer) {
//		try {
			CompletableFuture<SendResult<String, Customer>> future = kafkaTemplate.send(topic, customer);
			future.whenComplete((result, ex) -> {
				if (ex == null) {
					System.out.println(
							"Send message [" + customer.toString() + result.getRecordMetadata().offset() + " ]");
				} else {
					System.out.println("Unable to send the message " + ex.getMessage());
				}
			});
//		} catch (Exception e) {
//			System.out.println("Unable to send the customer  " + e.getMessage());
//		}
	}
}
