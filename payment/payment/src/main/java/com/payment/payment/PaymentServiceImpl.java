package com.payment.payment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.payment.audit.AuditLog;
import com.payment.audit.AuditRepository;
@Service
public class PaymentServiceImpl implements PaymentService{

	PaymentRepository repo;
	AuditRepository audit;
	public PaymentServiceImpl(PaymentRepository repo,AuditRepository audit) {
		this.repo = repo;
		this.audit = audit;
	}
	
	@Override
	public List<Payment> getAllPayments() {
		return repo.findAll();
	}
	
	@Override
	public Payment getPaymentById(PaymentId id) {
		return repo.findById(id).orElseThrow();
	}

	@Override
	public String addPayment(Payment payment) {
		Payment p =repo.save(payment);
		logAction("Create","Payment Added"+payment.getId());
		if(Objects.nonNull(p)) {
			return "Payment Added";
		}else {
			return "Payment Not Added";
		}
		
	}

	@Override
	public String updatePayment(PaymentId id, Payment payment) {
		Optional<Payment> optional = repo.findById(id);
		if(optional.isPresent()) {
			Payment p = optional.get();
			p.setAmount(payment.getAmount());
			p.setStatus(payment.getStatus());
			repo.save(p);
			logAction("Update","Payment Updated"+payment.getId());
			return "Payment Updated";
		}
		return "Payment Update Failed";
	}

	@Override
	public String deletePayment(PaymentId id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			logAction("Delete","Payment Deleted"+id);
			return "Payment Deleted";
		}else {
			return "Payment Deletion Failed";
		}
	}
	private void logAction(String action,String desc) {
		AuditLog log = new AuditLog();
		log.setAction(action);
		log.setDescription(desc);
		log.setUser("system");
		log.setTimestamp(LocalDateTime.now());
		audit.save(log);
	}

	@Override
	public Page<AuditLog> getAllAuditLogs(Pageable pageable) {
		return audit.findAll(pageable);
	}

}
