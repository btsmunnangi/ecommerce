package com.product.product;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class ProductConsumer {
	ProductService service;
	 @KafkaListener(topics = "my-topic", groupId = "product-group")
	    public void consume(String message) {
		    System.out.println("Product Consumer:"+message);
	     }

}
