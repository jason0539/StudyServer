package com.daoming.study.bean;

import org.springframework.stereotype.Component;

/**
 * @Author daoming.lzh
 * @Date: 2021/3/7 上午11:57
 */
@Component
public class TestBeanFromAnnotation {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
