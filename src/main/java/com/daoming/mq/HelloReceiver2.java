package com.daoming.mq;

import com.daoming.utils.LogUtils;
import com.daoming.web.learn.domain.LearnResource;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitConfig.QUEUE_NAME)
public class HelloReceiver2 {
    @RabbitHandler
    public void process(String hello) {
        LogUtils.d("Receiver2  : " + hello);
    }

    @RabbitHandler
    public void process(LearnResource learnResource){
        LogUtils.d("Receiver2  : " + learnResource.toString());
    }
}
