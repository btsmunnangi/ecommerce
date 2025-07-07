package com.order.order;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
@Service
public class OrderServiceImpl implements OrderService{

	OrderRepository repo;
	
	public OrderServiceImpl(OrderRepository repo) {
		this.repo = repo;
	}

	public List<Order> listAllOrders() {
		return repo.findAll();
	}

	@Override
	public Order getOrder(Integer id) {
		return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order not found:"+id));
	}

	@Override
	public String createOrder(Order order) {
		if(repo.existsById(order.getId())) {
			throw new DuplicateResourceException("Order Already Exists");
		}else {
			repo.save(order);
		    return "Order Added";
		}
	}

	@Override
	public String updateOrder(Order order, Integer id) {
		Optional<Order> optional = repo.findById(id);
		if(optional.isPresent()) {
			Order ord = optional.get();
			ord.setAmount(order.getAmount());
			ord.setProdId(order.getProdId());
			ord.setUnits(order.getUnits());
			repo.save(ord);
			return "Order Updated";
		}else {
		  throw new ResourceNotFoundException("Record is not Found:"+id);
		}
	}

	@Override
	public String deleteOrder(Integer id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Order Deleted";
		}else {
		 throw new ResourceNotFoundException("Record is not Found:"+id);
		}
	}

}
