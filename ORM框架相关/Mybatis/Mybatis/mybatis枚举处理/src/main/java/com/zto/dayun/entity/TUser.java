package com.zto.dayun.entity;

import com.zto.dayun.enums.EnumStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TUser {
    private String id;

    private String accountid;

    private String username;

    private EnumStatus statusdef;//枚举属性，使用mybatis默认转换类

    private EnumStatus statusordinal;//枚举属性，使用EnumOrdinalTypeHandler转换  按照位置匹配1开始

    private EnumStatus statuscustom; // 枚举属性，自定义枚举转换类

}