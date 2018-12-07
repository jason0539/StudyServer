package com.daoming.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    //更高级的用法参考http://www.ityouknow.com/springboot/2016/11/30/spring-boot-rabbitMQ.html
    public static final String QUEUE_NAME = "queue_of_test";

    @Bean
    public Queue Queue() {
        return new Queue(QUEUE_NAME);
    }
}
