package com.daoming.study.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author daoming.lzh
 * @Date: 2021/3/7 下午1:06
 */
@Configuration
@ComponentScan("com.daoming.study")
public class BeanConfig {

    @Bean
    public TestBeanFromBean testBeanFromConfig() {
        return new TestBeanFromBean();
    }
}
