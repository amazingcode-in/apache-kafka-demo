package com.amazingcode.in.example.kafka.producer;

import com.amazingcode.in.example.entity.Payment;
import com.amazingcode.in.example.kafka.constant.TopicConstant;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducer {

    private final KafkaTemplate<String, Payment> kafkaTemplate;

    public PaymentProducer(KafkaTemplate<String, Payment> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void producePaymentEvent(Payment payment){
        kafkaTemplate.send(TopicConstant.PAYMENT_TOPIC, payment);
    }
}
