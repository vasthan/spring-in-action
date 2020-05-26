package com.adc.spring.redis;

import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class DelayQueue {
    private Jedis producer;
    private Jedis consumer;

    public DelayQueue() {
        this.producer = new Jedis("127.0.0.1", 6379);
        this.consumer = new Jedis("127.0.0.1", 6379);
    }

    public void put(String taskName, long seconds) {
        producer.zadd("task", System.currentTimeMillis() + seconds * 1000, taskName);
    }

    public void run() {
        new Thread(this::process).start();
    }

    private void process() {
        while (true) {
            Set<String> tasks = consumer.zrangeByScore("task", 0, System.currentTimeMillis());
            if (!tasks.isEmpty()) {
                for (String task : tasks) {
                    producer.zrem("task", task);
                    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 执行任务：" + task);
                }
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DelayQueue delayQueue = new DelayQueue();
        delayQueue.run();
        for (int i = 0; i < 20; i++) {
            delayQueue.put("task" + i, 5);
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 放入延时任务：task" + i);
            Thread.sleep(1000);
        }
    }
}
