package com.order.order;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

	 private static final String TOPIC = "my-topic";
	 private final KafkaTemplate<String, String> kafkaTemplate;
	 public OrderProducer(KafkaTemplate<String, String> kafkaTemplate) {
	       this.kafkaTemplate = kafkaTemplate;
	 }
	 public void sendMessage(String message) {
	       kafkaTemplate.send(TOPIC, message);
	 }
}
