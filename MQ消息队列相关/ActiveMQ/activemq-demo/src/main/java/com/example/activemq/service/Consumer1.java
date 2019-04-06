package com.example.activemq.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @auther: YAO
 * @date: 2018/11/6 09:55
 * @description: 第二个消费者
 *              （这里不光消费了生产者插入队列中的message，
 *              而且将返回值插入到了"return.queue"队列中）
 */
@Component
@Slf4j
public class Consumer1 {

    /**
     * 消费模式 （消费后返回数据）
     * @param message
     * @return
     */
    @JmsListener(destination = "mytest.queue")
    @SendTo("return.queue")
    public String receiveQueue(String message){
        log.info("Consumer1收到的报文为:{}",message);
        return "========return message " + message;
    }

    /**
     * 订阅模式
     * @param text
     */
    @JmsListener(destination = "test.topic")
    public void receiveQueue1(String text){
        log.info("Consumer1收到的----topic----报文为:{}",text);
    }
}
