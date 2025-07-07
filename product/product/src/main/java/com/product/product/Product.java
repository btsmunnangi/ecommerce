package com.product.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="products")
public class Product {
@Id
private Integer id;
private String name;
private Integer qty;
private String category;
public Product() {
	
}
public Product(Integer id, String name, Integer qty, String category) {
	super();
	this.id = id;
	this.name = name;
	this.qty = qty;
	this.category = category;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getQty() {
	return qty;
}
public void setQty(Integer qty) {
	this.qty = qty;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}

}
