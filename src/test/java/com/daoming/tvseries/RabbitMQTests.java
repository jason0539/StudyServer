package com.daoming.tvseries;

import com.daoming.mq.HelloSender;
import com.daoming.utils.LogUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTests {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello() throws Exception {
        String context = "hello " + new Date();
        LogUtils.d("Sender : " + context);
        helloSender.send(context);
    }
}
