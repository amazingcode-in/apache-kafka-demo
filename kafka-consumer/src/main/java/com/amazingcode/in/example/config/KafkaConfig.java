package com.amazingcode.in.example.config;

import com.amazingcode.in.example.constant.KafkaConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    private final Logger logger = LoggerFactory.getLogger(KafkaConfig.class);

    @KafkaListener(topics = KafkaConstant.ORDER_PLACED_TOPIC_NAME, groupId = KafkaConstant.GROUP_ID)
    public void updateInventory(String value) {
        logger.info("Kafka listener -> {}",value);
        executeUpdateStock();
    }

    private void executeUpdateStock() {
        logger.info("Stock updated.");
    }
}
