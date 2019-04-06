package com.example.xmlconvertjson.test;

import com.example.xmlconvertjson.entity.MoBaoAccount;
import com.example.xmlconvertjson.utils.FileConvertByte;
import com.example.xmlconvertjson.utils.XStreamUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/16 11:57
 * @description:
 */
@Slf4j
public class XstreamTest {

    public static void main(String[] args) throws IOException {
        //获取xml文件
        Resource resource = new ClassPathResource("xml/order.xml");
        File file = resource.getFile();

        byte[] b = FileConvertByte.fileConverByte(file);

        MoBaoAccount moBaoAccount = XStreamUtil.toBean(MoBaoAccount.class,new String(b));

        log.info(new String(b));
    }
}
