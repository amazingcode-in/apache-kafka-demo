package com.amazingcode.in.example.service.impl;

import com.amazingcode.in.example.entity.Payment;
import com.amazingcode.in.example.kafka.producer.PaymentProducer;
import com.amazingcode.in.example.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    private final PaymentProducer paymentProducer;

    public PaymentServiceImpl(PaymentProducer paymentProducer) {
        this.paymentProducer = paymentProducer;
    }

    @Override
    public Payment executePayment(Payment payment) {
        generateTransactionId(payment);
        performTransaction(payment);
        logger.info("Sending notification to customer.");
        paymentProducer.producePaymentEvent(payment);
        return payment;
    }

    private void performTransaction(Payment payment) {
        logger.info("Executing transaction -> {}", payment.getTxnId());
        if(payment.getTxnType().equals("CREDIT")) {
            logger.info("Credit transaction completed with txn id -> {}", payment.getTxnId());
        } else if(payment.getTxnType().equals("DEBIT")) {
            logger.info("Debit transaction completed with txn id -> {}", payment.getTxnId());
        } else {
            logger.info("Invalid transaction.");
        }
    }

    private void generateTransactionId(Payment payment) {

        String txnId = "TXN-" +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) +
                "-" +
                UUID.randomUUID().toString().substring(0, 6);

        payment.setTxnId(txnId);
    }
}
