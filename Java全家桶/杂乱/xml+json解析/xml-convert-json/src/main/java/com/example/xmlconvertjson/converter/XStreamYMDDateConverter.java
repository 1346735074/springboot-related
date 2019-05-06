package com.example.xmlconvertjson.converter;

import com.example.xmlconvertjson.utils.StringUtils;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/17 14:10
 * @description: date时间类型转换
 */
public class XStreamYMDDateConverter extends AbstractSingleValueConverter {

    private static final DateFormat DEFAULT_DATEFORMAT = new SimpleDateFormat(
            "yyyy-MM-dd");

    @Override
    public boolean canConvert(Class type) {
        return type.equals(Date.class);
    }

    @Override
    public Object fromString(String str) {
        //去除空格以及回车(为了保证xml不规范做这个操作)
        str = StringUtils.replaceBlank(str);
        // 这里将字符串转换成日期
        try {
            return DEFAULT_DATEFORMAT.parseObject(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        throw new ConversionException("不能解析日期,字段为=" + str);
    }

    @Override
    public String toString(Object obj) {
        // 这里将日期转换成字符串
        return DEFAULT_DATEFORMAT.format((Date) obj);
    }
}
