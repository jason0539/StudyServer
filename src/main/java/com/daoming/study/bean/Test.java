package com.daoming.study.bean;

import java.util.UUID;
import java.util.function.Supplier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Author daoming.lzh
 * @Date: 2021/3/7 上午11:50
 * https://blog.csdn.net/qq_41907991/article/details/103589868
 */
public class Test {

    @Component
    public class TestBeanFromComponent{

    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        //supplier方式实例化bean
        ac.registerBean("testBeanFromSupplier", TestBeanFromSupplier.class, new Supplier<TestBeanFromSupplier>() {
            @Override
            public TestBeanFromSupplier get() {
                return new TestBeanFromSupplier("dm-" + UUID.randomUUID());
            }
        });
        ac.refresh();
        TestBeanFromSupplier testBeanFromSupplier = (TestBeanFromSupplier)ac.getBean("testBeanFromSupplier");
        System.out.println("testBeanFromSupplier.name:" + testBeanFromSupplier.getName());

        //xml配置方式实例化bean
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext(
            "applicationContext.xml");
        TestBeanFromXml testBeanFromXml = (TestBeanFromXml)xmlApplicationContext.getBean("testBeanFromXml");
        System.out.println("testBeanFromXml.name" + testBeanFromXml.getName());

        //bean注解实例化bean
        AnnotationConfigApplicationContext acBean = new AnnotationConfigApplicationContext(BeanConfig.class);
        TestBeanFromBean testBeanFromBean = (TestBeanFromBean)acBean.getBean("testBeanFromConfig");
        System.out.println("testBeanFromBean.name" + testBeanFromBean.getName());

        //注解方式实力bean
        //TestBeanFromAnnotation testBeanFromAnnotation = (TestBeanFromAnnotation)ac.getBean("testBeanFromAnnotation");
        //System.out.println("testBeanFromAnnotation.name" + testBeanFromAnnotation.getName());
    }
}

