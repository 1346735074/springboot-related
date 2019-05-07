package com.zto.dayun.result;

/**
 * @Auther: YAO
 * @Date: 2018/9/29 16:30
 * @Description: 存放请求结果参数信息
 */
public class MessageResultDto {
    /** 请求结果：S成功；E失败 .*/
    private String status;

    /** 错误代码 .*/
    private String errorCode;

    /** 错误信息 .*/
    private String errorMsg;

    /** 成功为结果对象，失败为空 .*/
    private String results;
}
