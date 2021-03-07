package com.daoming.study.bean;

/**
 * @Author daoming.lzh
 * @Date: 2021/3/7 上午11:03
 */
public class TestBeanFromSupplier {
    private String name;

    public TestBeanFromSupplier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
