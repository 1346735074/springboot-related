package com.example.demo.testredis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 *
 *
 * @author zhaoyao
 * @version 1.0
 * @date 2018/12/1 13
 * @description
 */
@Slf4j
public class TestJedis {
    @Test
    public void main() {

        RedisUtil redisUtil = getRedisUtil();
        redisUtil.rpush("list", "test", "nihao");
        Long list = redisUtil.rpush("list", "1", "2","3","4","5");

        log.info(list.toString());

        log.info("");
    }

    @Test
    public void test(){
        RedisUtil redisUtil = getRedisUtil();
        List<String> test = redisUtil.lrange("list", 0, 10-1);
        Assert.assertTrue(test!=null);
        log.info(test.toString());
    }

    @Test
    public void test1(){
        RedisUtil redisUtil = getRedisUtil();
        long start = 0;
        String list = redisUtil.ltrim("list", 10, -1);
        Assert.assertTrue(list!=null);
        log.info(list);
    }

    @Test
    public void test2(){
        RedisUtil redisUtil = getRedisUtil();
        System.out.println(redisUtil.sadd("123", "123"));
        System.out.println(redisUtil.sadd("123", "123"));
        System.out.println(redisUtil.sadd("123", "1231"));
        if (redisUtil.sadd("123", "1231") == 0L){
            System.out.println("12312123");
        }
    }

    @Test
    public void getSet(){
        RedisUtil redisUtil = getRedisUtil();
        redisUtil.smembers("123").stream().forEach(System.out::println);
        System.out.println(redisUtil.smembers("123").size());
    }

    public RedisUtil getRedisUtil(){
        JedisClient jedisClient = new JedisClient();
        JedisPool jedisPool = jedisClient.jedisPool();
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.setJedisPool(jedisPool);
        return redisUtil;
    }
}
