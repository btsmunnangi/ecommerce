package com.order.order;

import java.util.List;

public interface OrderService {
 public List<Order> listAllOrders();
 public Order getOrder(Integer id);
 public String createOrder(Order order);
 public String updateOrder(Order order,Integer id);
 public String deleteOrder(Integer id);
}
