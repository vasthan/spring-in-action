package com.adc.spring.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        Set<String> keys = jedis.keys("*");
        System.out.println(keys);

        jedis.set("foo", "bar");
    }
}
