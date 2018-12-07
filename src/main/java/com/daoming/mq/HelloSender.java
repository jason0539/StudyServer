package com.daoming.mq;

import com.daoming.web.domain.LearnResource;
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

    public void send(LearnResource learnResource){
        this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME,learnResource);
    }
}
