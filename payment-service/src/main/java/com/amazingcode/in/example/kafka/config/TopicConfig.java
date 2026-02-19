package com.amazingcode.in.example.kafka.config;

import com.amazingcode.in.example.kafka.constant.TopicConstant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder.name(TopicConstant.PAYMENT_TOPIC).build();
    }
}
