package com.adc.spring.ioc;

public class HelloServiceImpl implements HelloService{
    @Override
    public void hello(String name) {
        System.out.println("Hello " + name);
    }
}
