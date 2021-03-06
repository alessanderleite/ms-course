package com.example.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrpayroll.entities.Payment;
import com.example.hrpayroll.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

	@Autowired
	private PaymentService service;
	
	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable("workerId") Long workerId, @PathVariable("days") Integer days) {
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}
}
