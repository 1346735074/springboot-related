package com.example.xmlconvertjson.test;

import com.alibaba.fastjson.JSONObject;
import com.example.xmlconvertjson.utils.FileConvertByte;
import com.example.xmlconvertjson.utils.XMLConvertJSON;
import lombok.extern.slf4j.Slf4j;
import org.jdom2.JDOMException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/15 16:45
 * @description:
 */
@Slf4j
public class TestXml2Json {

    public static void main(String[] args) throws JDOMException, IOException {

        //获取xml文件
        Resource resource = new ClassPathResource("xml/Manifest_XML.cn.xml");
        File file = resource.getFile();

        //解析xml文档
        JSONObject json = XMLConvertJSON.xml2Json(FileConvertByte.fileConverByte(file));

        log.info(json.toJSONString());

    }
}
