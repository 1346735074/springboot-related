package com.example.activemq.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * @auther: YAO
 * @date: 2018/11/6 09:46
 * @description: 消息生产者
 */
@Service("producer")
@Slf4j
public class Provider {

    @Autowired
    JmsMessagingTemplate jmsTemplate;

    /**
     * 发送消息
     * @param destination 发送到的队列名
     * @param message 消息体
     */
    public void sendMessage(Destination destination, final String message){
        jmsTemplate.convertAndSend(destination, message);
    }

    /**
     * 消费消费者返回的队列"return.queue"中的消息
     * @param string
     */
    @JmsListener(destination = "return.queue")
    public void consumerMessage(String string){
        log.info("从return.queue队列收到的回复报文为:{}",string);
    }

}
