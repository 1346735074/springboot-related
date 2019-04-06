package com.example.xmlconvertjson.utils;

import com.alibaba.fastjson.JSONObject;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/15 16:50
 * @description: xml转json
 */
public class XMLConvertJSON {

    public static JSONObject xml2Json(byte[] xml) throws JDOMException, IOException {
        JSONObject jsonObject = new JSONObject();
        //将字符串转换为输入流
        InputStream is = new ByteArrayInputStream(xml);
        //用sax解析，解析一行丢一行
        SAXBuilder saxBuilder = new SAXBuilder();
        //获得xml文档
        Document document = saxBuilder.build(is);
        //获得根元素，例如xml
        Element rootElement = document.getRootElement();
        //调用具体解析方法
        jsonObject.put(rootElement.getName(),iterateElement(rootElement));
        return jsonObject;
    }

    private static JSONObject iterateElement(Element rootElement) {
        //获得所有子元素的集合
        List note = rootElement.getChildren();
        Element et;
        JSONObject jsonObject = new JSONObject();
        List list;
        for(int i=0;i<note.size();i++){
            list = new LinkedList();
            et = (Element) note.get(i);
            //此处是从>解析到<，如果有嵌套的子节点，则递归遍历
            if(et.getTextTrim().equals("")){
                if(et.getChildren().size() == 0) continue;
                //有这个键，则用最新的值替换
                if(jsonObject.containsKey(et.getName())){
                    list = (List)jsonObject.get(et.getName());
                }
                list.add(iterateElement(et));
                jsonObject.put(et.getName(),list);
            }else{
                if(jsonObject.containsKey(et.getName())){
                    list = (List)jsonObject.get(et.getName());
                }
                //获得值，例如<a>1</a>,得到1
                list.add(et.getTextTrim());
                jsonObject.put(et.getName(),list);
            }
        }
        return jsonObject;
    }
}
