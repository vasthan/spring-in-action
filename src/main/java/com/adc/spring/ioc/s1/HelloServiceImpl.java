package com.adc.spring.ioc.s1;

import java.io.PrintStream;

public class HelloServiceImpl implements HelloService{
    private PrintStream stream;

    public HelloServiceImpl(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void hello(String name) {
        stream.println("Hello " + name);
    }
}
