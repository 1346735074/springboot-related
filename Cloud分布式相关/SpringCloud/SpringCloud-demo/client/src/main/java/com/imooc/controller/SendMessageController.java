package com.imooc.controller;

import com.imooc.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * stream发送消息
 */
@RestController
public class SendMessageController {
    @Autowired
    private StreamClient streamClient;

    @GetMapping("/sendMessage")
    public void process() {
        String message = "Client send: now " + new Date();
        streamClient.output().send(MessageBuilder.withPayload(message).build());
    }
}
