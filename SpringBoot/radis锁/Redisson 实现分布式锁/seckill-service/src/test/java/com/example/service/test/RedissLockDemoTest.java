package com.example.service.test;

import com.example.service.RedissonApplicationTests;
import org.junit.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @auther: YAO
 * @date: 2018/11/5 14:50
 * @description:
 */
@Component
public class RedissLockDemoTest extends RedissonApplicationTests {

    @Autowired
    RedissonClient redissonClient;

    @Autowired
    RedissLockDemo redissLockDemo;


    // 请求总数
    public static int clientTotal = 200;

    // 同时并发执行的线程数
    public static int threadTotal = 100;

    @Test
    public void testReentrantLock() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    redissLockDemo.testReentrantLock(redissonClient);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();

    }

    @Test
    public void testAsyncReentrantLock() throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    redissLockDemo.testAsyncReentrantLock(redissonClient);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();

    }

    @Test
    public void testFairLock() {
    }

    @Test
    public void testMultiLock() {
    }

    @Test
    public void testRedLock() {
    }
}