package com.example.xmlconvertjson.utils;

import java.io.*;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/15 17:19
 * @description:
 */
public class FileConvertByte {

    /**
     * file转byte
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public static byte[] fileConverByte(File file) throws IOException {
        InputStream inputIs = new FileInputStream(file);
        //转换为byte
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100]; //buff用于存放循环读取的临时数据
        int rc = 0;
        while ((rc = inputIs.read(buff, 0, 100)) > 0) {
            outStream.write(buff, 0, rc);
        }
        //合并之后的字节数组
        byte[] in_merge = outStream.toByteArray();
        return  in_merge;
    }
}
