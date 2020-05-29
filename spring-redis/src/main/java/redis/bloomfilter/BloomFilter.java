package redis.bloomfilter;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.List;

public class BloomFilter {
    public static void main(String[] args) {

        RedisClient client = RedisClient.create("redis://localhost:6379");
        StatefulRedisConnection<String, String> connection = client.connect();
        RedisCommands<String, String> sync = connection.sync();
        List<String> keys = sync.keys("*");
        for (String key : keys) {
            System.out.printf("key: %s, type: %s\n" +
                    "", key, sync.type(key));
        }


    }
}
