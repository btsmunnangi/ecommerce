package com.order.order;

public class OrderDetails {
     private Integer orderId;
     private Integer prodId;
     private Integer units;
     
     public OrderDetails() {}
     public OrderDetails(Integer orderId, Integer prodId, Integer units) {
		this.orderId = orderId;
		this.prodId = prodId;
		this.units = units;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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
