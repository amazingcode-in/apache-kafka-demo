package com.amazingcode.in.example.controller;

import com.amazingcode.in.example.entity.Payment;
import com.amazingcode.in.example.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/initiate")
    ResponseEntity<Payment> initiatePayment(@RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.executePayment(payment));
    }
}
