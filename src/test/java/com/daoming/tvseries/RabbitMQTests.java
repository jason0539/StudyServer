package com.daoming.tvseries;

import com.daoming.mq.HelloSender;
import com.daoming.utils.LogUtils;
import com.daoming.web.learn.domain.LearnResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTests {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello() throws Exception {
        for (int i = 0; i < 10; i++) {
            String context = "hello " + i;
            LogUtils.d("Sender : " + context);
            helloSender.send(context);
        }
        helloSender.send(new LearnResource(11l,"jason","title","url"));
    }
}
