package com.imooc.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收mq消息
 */
@Slf4j
@Component
public class MyReceiver {

    //@RabbitListener(queues = "myQueue")
    //自动创建队列@RabbitListener(queuesToDeclare = @Queue("myQueue"))
    //自动创建队列（value）以及分组（exchange）
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message) {
        log.info("MqReceiver:{}", message);
    }
}
