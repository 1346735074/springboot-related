package com.example.demo.testredis;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 *
 *
 * @author zhaoyao
 * @version 1.0
 * @date 2018/12/1 13
 * @description
 */
@Slf4j
public class JedisClient {

    //spring.redis.host=39.105.130.205
    //spring.redis.password=Lianzhong321
    //spring.redis.port=6379


//    @Value("${spring.redis.host}")
    private String host = "101.132.189.80";
//    @Value("${spring.redis.port}")
    private int port = 6379;
//    @Value("${spring.redis.password}")
    private String passPort = "1hblsqT!";

    public Jedis jedis(){
        Jedis jedis = new Jedis("39.106.31.224", 6379);
        log.info("jedis");
        return jedis;
    }

    public JedisPool jedisPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        // 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
        // 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
        config.setMaxTotal(200);
        // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        config.setMaxIdle(100);
        // 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
        config.setMaxWaitMillis(200);
        //不阻塞
        config.setBlockWhenExhausted(false);
        //在空闲时间逐出
        config.setTestWhileIdle(true);
        //逐出线程运行时间间隔
        config.setTimeBetweenEvictionRunsMillis(60 * 1000);
        //每次逐出数量
        config.setNumTestsPerEvictionRun(200);
        // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
        config.setTestOnBorrow(false);
        config.setTestOnReturn(false);
        return new JedisPool(config, host, port, 500, passPort);
    }

}
