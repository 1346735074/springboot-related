package com.example.xmlconvertjson.entity.Manifest_XML;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/17 13:52
 * @description:
 */
@Data
@XStreamAlias("transmission") //对应根节点
public class Transmission {
    private Message message;
}
