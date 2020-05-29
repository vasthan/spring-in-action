package redis.hyperloglog;

import redis.clients.jedis.Jedis;

public class HyperLogLogTest2 {
    public static void main(String[] args) {

        Jedis jedis = new Jedis();

        // for (int i = 0; i < 10000; i++) {
        //     if (i % 2 == 0) {
        //         jedis.pfadd("uv:0", i + "");
        //     } else {
        //         jedis.pfadd("uv:1", i + "");
        //     }
        // }
        // System.out.println(jedis.pfcount("uv:0"));
        // System.out.println(jedis.pfcount("uv:1"));
        // System.out.println(jedis.pfcount("uv:0", "uv:1"));

        String res = jedis.pfmerge("uv:lala", "uv:0", "uv:1");
        System.out.println(res);
    }
}
