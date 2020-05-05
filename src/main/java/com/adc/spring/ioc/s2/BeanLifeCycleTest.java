package com.adc.spring.ioc.s2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 测试Bean的生命周期
 */
public class BeanLifeCycleTest implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor, InitializingBean, DisposableBean {

    public BeanLifeCycleTest() {
        System.out.println("执行构造方法...");
    }

    public void doSomeThing() {
        System.out.println("doSomeThing");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName(): " + name);
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory()");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext()");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization()");
        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet()");
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization()");
        return bean;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy()");
    }

    public void myInit() {
        System.out.println("执行myInit()");
    }

    public void myDestroy() {
        System.out.println("执行myDestroy()");
    }
}
