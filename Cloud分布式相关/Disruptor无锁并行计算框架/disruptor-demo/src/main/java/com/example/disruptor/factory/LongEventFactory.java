package com.example.disruptor.factory;

import com.example.disruptor.entity.LongEvent;
import com.lmax.disruptor.EventFactory;

/**
 * @auther: YAO
 * @date: 2018/11/2 17:22
 * @description: 实例化Event对象
 */
public class LongEventFactory implements EventFactory {

    @Override
    public Object newInstance() {
        return new LongEvent();
    }
}
