package com.order.order;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="orders")
public class Order {
@Id
private Integer id;
private Double amount;
private Integer prodId;
private Integer units;

public Order() {
	
}
public Order(Integer id, Double amount, Integer prodId) {
	this.id = id;
	this.amount = amount;
	this.prodId = prodId;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}
public Integer getProdId() {
	return prodId;
}
public void setProdId(Integer prodId) {
	this.prodId = prodId;
}
public Integer getUnits() {
	return units;
}
public void setUnits(Integer units) {
	this.units = units;
}
}
