package com.example.service.queue;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @auther: YAO
 * @date: 2018/11/6 10:50
 * @description:
 */
@Service
public class ActiveMQConsumer {


    @JmsListener(destination = "seckill.queue")
    public void receiveQueue(String message) {
        //收到通道的消息之后执行秒杀操作(超卖)
        String[] array = message.split(";");

    }
}
