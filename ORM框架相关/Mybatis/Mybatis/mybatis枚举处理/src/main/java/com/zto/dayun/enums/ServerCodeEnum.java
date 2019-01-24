package com.zto.dayun.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: YAO
 * @Date: 2018/9/29 17:05
 * @Description: 服务代码
 */
@Getter
@AllArgsConstructor
public enum ServerCodeEnum {

    SIGN_PDA("signPda","签收服务"),
    RECEIVE("receive","到件确认服务"),
    DISPATCH_SCAN("dispatchScan","派件扫描服务"),
    SEND_SCAN("sendScan","发件扫描服务"),
    RECEIVE_SCAN("receiveScan","收件扫描服务"),
    ;

    private String codeqwe;
    private String codeInfoqw;
}
