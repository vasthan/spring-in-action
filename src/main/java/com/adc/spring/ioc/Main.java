package com.adc.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    private static AtomicBoolean active = new AtomicBoolean();
    private static AtomicBoolean closed = new AtomicBoolean();

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloService helloService = context.getBean(HelloService.class);
        helloService.hello("adc");

    }
}
