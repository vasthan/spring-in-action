package redis.pipeline;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.List;

public class Pipeline1 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Pipeline pipeline = jedis.pipelined();
        for (int i = 0; i < 100; i++) {
            pipeline.set("k" + i, i + "");
        }
        List<Object> results = pipeline.syncAndReturnAll();
        System.out.println(results);

        for (int i = 0; i < 100; i++) {
            pipeline.get("k" + i);
        }
        // 返回的结果顺序和pipeline中的命令顺序是一致的
        results = pipeline.syncAndReturnAll();
        System.out.println(results);
    }
}
