package com.adc.spring.ioc.s3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("s3.xml");
        context.getBean("s3", BeanInstantiateTest.class);
    }
}
