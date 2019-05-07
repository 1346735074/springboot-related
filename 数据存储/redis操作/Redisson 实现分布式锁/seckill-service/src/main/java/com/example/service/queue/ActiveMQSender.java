package com.example.service.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * @auther: YAO
 * @date: 2018/11/6 10:49
 * @description:
 */
@Component

public class ActiveMQSender {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    /**
     * 发送消息，destination是发送到的队列，message是待发送的消息
     * @param destination
     * @param message
     */
    public void sendChannelMess(Destination destination, final String message){
        jmsTemplate.convertAndSend(destination, message);
    }

}
