package com.daoming.tvseries;

import com.daoming.utils.LogUtils;
import com.daoming.web.domain.LearnResource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTestes {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        String stringKey = "a";
        String stringValue = "String Value is " + System.currentTimeMillis();
        redisTemplate.opsForValue().set(stringKey, stringValue);
        LogUtils.d("redis中获取string值为：" + redisTemplate.opsForValue().get(stringKey));
        Assert.assertEquals(stringValue, redisTemplate.opsForValue().get(stringKey));


        String objectKey = "b";
        long objectId = System.currentTimeMillis();
        LearnResource objectValue = new LearnResource(objectId, "11", "11", "11");
        redisTemplate.opsForValue().set(objectKey, objectValue);

        LearnResource learnResource = (LearnResource) redisTemplate.opsForValue().get(objectKey);
        if (learnResource != null) {
            LogUtils.d("从redis拿到的learnResource:" + learnResource.toString());
            Assert.assertEquals(objectId, learnResource.getId().longValue());
        } else {
            LogUtils.d("从redis拿到的learnResource空的");
        }
    }
}
