package com.order.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
  @Autowired	
  OrderService service;	
  @Autowired
  OrderProducer producer;
  @GetMapping
  public ResponseEntity<List<Order>> listAllOrders(){
	 return new ResponseEntity<List<Order>>(service.listAllOrders(),HttpStatus.OK);
  }
  @GetMapping("/{id}")
  public ResponseEntity<Order> getOrder(@PathVariable Integer id) {
	  return new ResponseEntity<Order>(service.getOrder(id),HttpStatus.OK);
  }
  @PostMapping
  public ResponseEntity<String> createOrder(@RequestBody Order order) {
	  producer.sendMessage("Order is Created");
	  return new ResponseEntity<String>(service.createOrder(order),HttpStatus.OK);
  }
  @PutMapping("/{id}")
  public ResponseEntity<String> updateOrder(@RequestBody Order order,@PathVariable Integer id) {
	  return new ResponseEntity<String>(service.updateOrder(order, id),HttpStatus.OK);
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteOrder(@PathVariable Integer id) {
	  return new ResponseEntity<String>(service.deleteOrder(id),HttpStatus.OK);
  }
}
