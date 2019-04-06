package com.example.xmlconvertjson.utils;

import com.thoughtworks.xstream.XStream;
import lombok.extern.slf4j.Slf4j;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/16 08:48
 * @description:
 */
@Slf4j
public class XStreamUtil {

    /**
     * xml字符串转java对象
     * @param clazz java对象
     * @param xml xml字符串
     * @param <T>
     * @return
     */
    public static <T> T toBean(Class<T> clazz, String xml) {
        try {
            XStream xstream = new XStream();
            xstream.processAnnotations(clazz);
            xstream.autodetectAnnotations(true);
            xstream.setClassLoader(clazz.getClassLoader());
            return (T) xstream.fromXML(xml);
        } catch (Exception e) {
            log.error("[XStream]XML转对象出错:{}", e);
            throw new RuntimeException("[XStream]XML转对象出错");
        }
    }
}
