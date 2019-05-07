package com.example.demo.testredis.error;

public interface ResultCode {
    /** 参数错误异常码 */
    String ILLEGAL_PARAMETER_CODE = "TXP100";
    /** 系统异常*/
    String SYS_ERR = "TXP500";
    /** 业务异常*/
    String BIZ_ERROR = "TXP400";
}
