package com.daoming.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String QUEUE_NAME = "queue_of_test";

    @Bean
    public Queue Queue() {
        return new Queue(QUEUE_NAME);
    }
}
