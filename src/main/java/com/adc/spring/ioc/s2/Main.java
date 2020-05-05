package com.adc.spring.ioc.s2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("s2.xml");
        BeanLifeCycleTest l1 = context.getBean("lifeCycle", BeanLifeCycleTest.class);
        BeanLifeCycleTest l2 = context.getBean("foo", BeanLifeCycleTest.class);
        BeanLifeCycleTest l3 = context.getBean("bar", BeanLifeCycleTest.class);

        // System.out.println(l1 == l2);
        // System.out.println(l1 == l3);
        // System.out.println(l2 == l3);

        l1.doSomeThing();
        context.close();
    }
}
