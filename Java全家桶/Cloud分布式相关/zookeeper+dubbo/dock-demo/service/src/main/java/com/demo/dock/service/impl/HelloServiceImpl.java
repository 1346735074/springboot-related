package com.demo.dock.service.impl;

import com.demo.dock.service.IHelloService;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/18 10:34
 * @description: 测试接口 继承公共interface
 */
@Service
public class HelloServiceImpl implements IHelloService {

    @Override
    public String echo(String name) {
        return "你好这个是个测试的接口 你刚刚输入的内容为：" + name;
    }

}
