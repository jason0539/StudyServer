package com.daoming.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String context) {
        this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, context);
    }
}
