package com.zto.dayun.dto;

import lombok.Data;
import lombok.Getter;

/**
 * @Auther: YAO
 * @Date: 2018/9/29 16:17
 * @Description: 用于pda请求时存放请求参数信息
 */
@Data
public class ParamDto {

    /** 用户名. */
    private String username;

    /** 密码. */
    private String password;

    /** 服务代码. */
    private String serverCode;

    /** 请求参数. */
    private String params;
}
