package com.example.activemq.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @auther: YAO
 * @date: 2018/11/6 09:53
 * @description: 第一个消费者
 */
@Component
@Slf4j
public class Consumer {

    /**
     * 消费模式
     * @param text
     */
    @JmsListener(destination = "mytest.queue")
    public void receiveQueue(String text){
        log.info("Consumer收到的报文为:{}",text);
    }

    /**
     * 订阅模式
     * @param text
     */
    @JmsListener(destination = "test.topic")
    public void receiveQueue1(String text){
        log.info("Consumer收到的----topic----报文为:{}",text);
    }
}
