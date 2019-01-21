package com.example.demo.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *
 *
 * @author zhaoyao
 * @version 1.0
 * @date 2019-01-15
 */
@Component
public class RedisTemplateTest {

    @Resource
    private RedisTemplate redisTemplate;

    public void test(){
        redisTemplate.opsForValue();//操作字符串
        redisTemplate.opsForHash();//操作hash
        redisTemplate.opsForList();//操作list
        redisTemplate.opsForSet();//操作set
        redisTemplate.opsForZSet();//操作有序set
    }
}
