package redis.hyperloglog;

import redis.clients.jedis.Jedis;

import java.util.Random;
import java.util.Set;

public class HyperLogLogTest1 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);

        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            jedis.pfadd("uv", i + "");
        }
        System.out.println(jedis.pfcount("uv"));

        for (int i = 0; i < 100000; i++) {
            jedis.incr("pv");
        }

        System.out.println(jedis.get("pv"));
    }
}
