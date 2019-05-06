package com.example.service.service;

/**
 * @auther: YAO
 * @date: 2018/11/5 15:55
 * @description:
 */
public interface ISeckillDistributedService {

    /**
     * radis锁秒杀
     * @param seckillId 商品id
     * @return
     */
    Object startRedisLock(long seckillId);
}

