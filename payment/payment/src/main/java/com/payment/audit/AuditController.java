package com.payment.audit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.payment.PaymentService;

@RestController
@RequestMapping("/api/v1/audit")
public class AuditController {
  PaymentService service;
  @Autowired
  public AuditController(PaymentService service) {
	this.service = service;
  }
  @GetMapping
  public ResponseEntity<Page<AuditLog>> getAllAuditLogs(){
	Pageable pageable = PageRequest.of(0, 5, Sort.by("Desc"));  
	return new ResponseEntity<Page<AuditLog>>(service.getAllAuditLogs(pageable),HttpStatus.OK);  
  }
}
