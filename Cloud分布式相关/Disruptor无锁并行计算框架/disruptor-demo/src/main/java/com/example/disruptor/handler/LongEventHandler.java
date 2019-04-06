package com.example.disruptor.handler;


import com.example.disruptor.entity.LongEvent;
import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @auther: YAO
 * @date: 2018/11/2 17:24
 * @description: 事件消费者:事件处理器简单地把事件中存储的数据打印到终端
 */
@Slf4j
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        log.info(String.valueOf(longEvent.getValue()));
    }
}
