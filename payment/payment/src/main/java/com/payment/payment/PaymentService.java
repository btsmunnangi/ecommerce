package com.payment.payment;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.payment.audit.AuditLog;

public interface PaymentService {
	public List<Payment> getAllPayments();
	public Payment getPaymentById(PaymentId id);
    public String addPayment(Payment payment);
    public String updatePayment(PaymentId id,Payment payment);
    public String deletePayment(PaymentId id);
	public Page<AuditLog> getAllAuditLogs(Pageable pageable);
}
