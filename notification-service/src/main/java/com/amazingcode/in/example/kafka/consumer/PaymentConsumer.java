package com.amazingcode.in.example.kafka.consumer;

import com.amazingcode.in.example.entity.Payment;
import com.amazingcode.in.example.kafka.constant.GroupConstant;
import com.amazingcode.in.example.kafka.constant.TopicConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Configuration
public class PaymentConsumer {

    private static final Logger logger = LoggerFactory.getLogger(PaymentConsumer.class);

    @KafkaListener(topics = TopicConstant.PAYMENT_TOPIC, groupId = GroupConstant.GROUP_ID)
    public void sendNotification(Payment payment) {
        if(payment.getTxnType().equals("CREDIT")) {
            logger.info("Message sent: Your account is credited with {} and transaction id is {}", payment.getAmount(), payment.getTxnId());
        } else if(payment.getTxnType().equals("DEBIT")) {
            logger.info("Message sent: Your account is debited with {} and transaction id is {}", payment.getAmount(), payment.getTxnId());
        } else {
            logger.info("Message sent: Something is wrong, Please check your account activity.");
        }
    }
}
