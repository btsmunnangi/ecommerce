package com.payment.payment;

import java.util.List;

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
@RequestMapping("/api/v1/payments")
public class PaymentController {
	PaymentService service;
	
	public PaymentController(PaymentService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<List<Payment>> getAllPayments(){
		return new ResponseEntity<List<Payment>>(service.getAllPayments(),HttpStatus.OK);
	}
	@GetMapping("/{orderId}/{paymentSeq}")
	public ResponseEntity<Payment> getPayment(@PathVariable String orderId,@PathVariable Integer paymentSeq) {
		return new ResponseEntity<Payment>(service.getPaymentById(new PaymentId(orderId,paymentSeq)),HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<String> addPayment(@RequestBody Payment payment) {
		return new ResponseEntity<String>(service.addPayment(payment),HttpStatus.CREATED);
	}
	@PutMapping("/{orderId}/{paymentSeq}")
    public ResponseEntity<String> updatePayment(@PathVariable String orderId,@PathVariable Integer paymentSeq,@RequestBody Payment payment) {
    	return new ResponseEntity<String>(service.updatePayment(new PaymentId(orderId,paymentSeq), payment),HttpStatus.OK);
    }
	@DeleteMapping("/{orderId}/{paymentSeq}")
    public ResponseEntity<String> deletePayment(@PathVariable String orderId,@PathVariable Integer paymentSeq) {
    	return new ResponseEntity<String>(service.deletePayment(new PaymentId(orderId,paymentSeq)),HttpStatus.OK);
    }
}
