package com.example.xmlconvertjson.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/16 10:44
 * @description:
 */
@Data
@XStreamAlias("MoBaoAccount") //对应根节点
public class MoBaoAccount {

    private String OrderNo;

    private String TradeAmt;

    private String Commission;

    private User User;
}
