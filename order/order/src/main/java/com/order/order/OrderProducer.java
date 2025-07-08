package com.order.order;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

	 private static final String TOPIC = "my-topic";
	 private final KafkaTemplate<String, OrderDetails> kafkaTemplate;
	 public OrderProducer(KafkaTemplate<String, OrderDetails> kafkaTemplate) {
	       this.kafkaTemplate = kafkaTemplate;
	 }
	 public String sendMessage(Order order) {
		   OrderDetails dts = new OrderDetails();
		   dts.setOrderId(order.getId());
		   dts.setProdId(order.getProdId());
		   dts.setUnits(order.getUnits());
	       kafkaTemplate.send(TOPIC, dts);
	       return "Message Sent:"+dts.getProdId();
	 }
}
