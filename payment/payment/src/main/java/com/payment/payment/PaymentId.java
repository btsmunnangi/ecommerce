package com.payment.payment;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class PaymentId implements Serializable{
	private String orderId;
    private int paymentSeq;
    public PaymentId() {}
    
	public PaymentId(String orderId, int paymentSeq) {
		this.orderId = orderId;
		this.paymentSeq = paymentSeq;
	}

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getPaymentSeq() {
		return paymentSeq;
	}
	public void setPaymentSeq(int paymentSeq) {
		this.paymentSeq = paymentSeq;
	}
	@Override
	public int hashCode() {
		return Objects.hash(orderId, paymentSeq);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentId other = (PaymentId) obj;
		return Objects.equals(orderId, other.orderId) && paymentSeq == other.paymentSeq;
	}
	@Override
	public String toString() {
		return "PaymentId [orderId=" + orderId + ", paymentSeq=" + paymentSeq + "]";
	}
   
}
