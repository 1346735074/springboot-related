package com.example.activemq.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * @auther: YAO
 * @date: 2018/11/6 09:58
 * @description: 测试发消息
 */
@Service
@Slf4j
public class SpringbootJmsApplicationTests {

    @Autowired
    private Provider provider;

    /**
     * 1对1
     */
    public void contextLoads(){
        Destination destination = new ActiveMQQueue("mytest.queue");
        for (int i = 0; i < 10; i++) {
            provider.sendMessage(destination, "huangzhang "+i);
        }
    }

    /**
     * 1对多
     */
    public void topicSend(){
        Destination destination  = new ActiveMQTopic("test.topic");
        for (int i = 0; i < 10 ; i++){
            provider.sendMessage(destination, "topic"+i);
        }
    }
}
