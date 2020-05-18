package com.adc.spring.redis;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RedisConfig.class);
        RedisTemplate<String, String> redisTemplate = context.getBean(RedisTemplate.class);
        ListOperations<String, String> ops = redisTemplate.opsForList();
        List<String> tasks = ops.range("tasks", 0, -1);
        System.out.println(tasks);
    }
}
