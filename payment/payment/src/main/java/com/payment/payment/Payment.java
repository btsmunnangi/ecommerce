package com.payment.payment;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Payment")
public class Payment {
  @EmbeddedId
  private PaymentId id;
  private Integer amount;
  private String status;
  public Payment() {}
  public Payment(PaymentId id, Integer amount, String status) {
	this.id = id;
	this.amount = amount;
	this.status = status;
   }
	public PaymentId getId() {
		return id;
	}
	public void setId(PaymentId id) {
		this.id = id;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
  
  
}
