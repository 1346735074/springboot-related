package com.example.demo.testredis.error;

import lombok.Data;

/**
 * 业务异常类
 *
 * @author lj
 */
@Data
public class RedisException extends RuntimeException implements IErrorCode {
    private String code = ResultCode.BIZ_ERROR;
    private String msg;
    private boolean isShowMsg = true;

    public RedisException(IErrorCode iErrorCode) {
        super(iErrorCode.getMsg());
        this.code = iErrorCode.getCode();
        this.msg = iErrorCode.getMsg();
    }

    public RedisException(Throwable e){
        super(e);
    }

    public RedisException(String errorMsg) {
        super(errorMsg);
        this.msg = errorMsg;
    }

    public RedisException(String errorMsg, boolean isShowMsg) {
        super(errorMsg);
        this.msg = errorMsg;
        this.isShowMsg = isShowMsg;
    }

    public RedisException(String code, String errorMsg) {
        super(errorMsg);
        this.code = code;
        this.msg = errorMsg;
    }

    @Override
    public String getMsg() {
        return isShowMsg ? msg : "";
    }
}
