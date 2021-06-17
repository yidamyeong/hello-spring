package com.dam.hellospring.connect;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConnectTest {

    @Test
    public void testRedisConnect(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        JedisPool pool = new JedisPool(jedisPoolConfig, "172.16.113.91", 6379, 1000, "douzone1!", 14);

        Jedis jedis = pool.getResource();

        jedis.set("testKey", "testVal");
        String value = jedis.get("testKey");
        Assertions.assertTrue( value != null && value.equals("testVal") );

        jedis.del("testKey");
        value = jedis.get("testKey");
        Assertions.assertTrue( value == null );

        System.out.println(jedis.get("NO_TOKEN_SERVICE_CODE"));

        if( jedis != null ){
            jedis.close();
        }
    }
}
