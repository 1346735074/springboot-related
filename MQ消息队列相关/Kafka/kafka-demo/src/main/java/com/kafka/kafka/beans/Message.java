package com.kafka.kafka.beans;

import lombok.Data;

import java.util.Date;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/17 17:03
 * @description:
 */
@Data
public class Message {

    private Long id;    //id

    private String msg; //消息

    private Date sendTime;  //时间戳
}
