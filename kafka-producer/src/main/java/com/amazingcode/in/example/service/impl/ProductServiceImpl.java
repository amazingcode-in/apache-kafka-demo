package com.amazingcode.in.example.service.impl;

import com.amazingcode.in.example.constant.KafkaConstant;
import com.amazingcode.in.example.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProductServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String placeOrder() {
        executeOrder();
        kafkaTemplate.send(KafkaConstant.ORDER_PLACED_TOPIC_NAME, "Order placed.");
        return "Congratulations! Your order is placed...";
    }

    private void executeOrder() {
        logger.info("Order executed.");
    }
}
