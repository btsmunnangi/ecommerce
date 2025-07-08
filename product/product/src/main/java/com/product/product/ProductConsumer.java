package com.product.product;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.order.order.OrderDetails;
@Service
public class ProductConsumer {
	ProductService service;
	 @KafkaListener(topics = "my-topic", groupId = "product-group")
	    public void consume(OrderDetails details) {
		    System.out.println("Product Consumer:"+details.getProdId());
	     }

}
