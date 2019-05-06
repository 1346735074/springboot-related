package com.imooc.controller;

import com.imooc.message.StreamClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * stream发送消息
 */
@Api(value="stream发送消息",tags ="stream发送消息")
@RestController
public class SendMessageController{

    @Autowired
    private StreamClient streamClient;

    @ApiOperation(value="发送MQ", notes="发送MQ消息（order->client）")
    @GetMapping("/sendMessage")
    public void process() {
        String message = "Order send: now " + new Date();
        streamClient.output().send(MessageBuilder.withPayload(message).build());
    }

    @ApiOperation(value="测试接口", notes="这个是个测试接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "name", value = "测试用户", required = true, dataType = "String")
    })
    @GetMapping("cs")
    public void cs(@PathVariable Long id, @PathVariable String name){

    }
}
