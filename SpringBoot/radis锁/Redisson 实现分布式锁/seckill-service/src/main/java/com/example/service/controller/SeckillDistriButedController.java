package com.example.service.controller;

import com.example.service.service.ISeckillDistributedService;
import com.example.service.service.impl.SeckillDistributedServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @auther: YAO
 * @date: 2018/11/5 16:12
 * @description:
 */
@RestController
@RequestMapping("seckill")
@Slf4j
public class SeckillDistriButedController {

    @Autowired
    ISeckillDistributedService seckillDistributedService;

    private static int corePoolSize = Runtime.getRuntime().availableProcessors();
    //调整队列数 拒绝服务
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize,corePoolSize+1,
            101, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(10000));

    /**
     * 单个秒杀
     * @param seckillId
     * @return
     */
    @RequestMapping("/startRedisLock")
    public Object startRedisLock(long seckillId){
        return seckillDistributedService.startRedisLock(seckillId);
    }

    /**
     * 一个请求模拟n个秒杀
     * @param seckillId
     * @return
     */
    @RequestMapping("/startRedisLocks")
    public Object startRedisLocks(long seckillId){
        log.info("开始秒杀");
        for (int i = 0; i < 10000; i++) {
            //开启线程
            Runnable task = () ->{
                //执行秒杀
                Object o = seckillDistributedService.startRedisLock(seckillId);
//                log.info("这次的结果为：{}",o);
            };
            executor.execute(task);
        }
        try {
            Thread.sleep(15000);
            log.info("一共秒杀{}件商品", SeckillDistributedServiceImpl.ii);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "一共秒杀"+SeckillDistributedServiceImpl.ii+"件商品";
    }

    /**
     * 秒杀(ActiveMQ分布式队列
     * @param seckillId
     */
    @PostMapping("/startActiveMQQueue")
    public Object startActiveMQQueue(long seckillId){
        log.info("开始秒杀");
        for (int i = 0; i < 10000; i++) {
            //开启线程
            Runnable task = () ->{
                //创建队列
                Destination destination = new ActiveMQQueue("seckill.queue");
            };
            executor.execute(task);
        }
        try {
            Thread.sleep(15000);
            log.info("一共秒杀{}件商品",SeckillDistributedServiceImpl.ii);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "一共秒杀"+SeckillDistributedServiceImpl.ii+"件商品";
    }
}
