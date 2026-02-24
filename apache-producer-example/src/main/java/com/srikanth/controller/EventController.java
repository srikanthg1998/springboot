package com.srikanth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srikanth.dto.Customer;
import com.srikanth.service.KafkaMessagePublisher;

@RestController
@RequestMapping("/producer-app")
public class EventController {

	@Autowired
	private KafkaMessagePublisher kafkaMessagePublisher;

	/*
	 * @GetMapping("publish/{message}") public ResponseEntity<?>
	 * publishMessage(@PathVariable String message) { try { for (int i = 0; i <
	 * 10000; i++) { kafkaMessagePublisher.sendMessage(message + " " + i); } return
	 * ResponseEntity.ok("message published successfully!!"); } catch (Exception e)
	 * { return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); }
	 * 
	 * }
	 */

	@PostMapping("/publish")
	public ResponseEntity<String> publishEventMessage(@RequestBody Customer customer) {
		try {
			kafkaMessagePublisher.sendEventMessage(customer);
			return ResponseEntity.ok("message published successfully!!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}
