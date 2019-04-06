package com.example.xmlconvertjson.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/17 14:31
 * @description:
 */
public class StringUtils {

    /**
     * 去除字符串中所有的空格、回车、换行符、制表符
     * @param str
     * @return
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.replaceBlank("just do it!"));
    }
}
