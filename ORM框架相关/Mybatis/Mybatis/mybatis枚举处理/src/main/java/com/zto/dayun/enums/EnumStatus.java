package com.zto.dayun.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: YAO
 * @Date: 2018/9/30 10:33
 * @Description:
 */
@Getter
@AllArgsConstructor
//@JsonFormat(shape = JsonFormat.Shape.OBJECT) //返回整个枚举对象
public enum EnumStatus {
    NORMAL(1, "正常"),
    DELETE(0, "删除"),
    CANCEL(2, "注销");

    private Integer code;
    @JsonValue //返回这个属性的值
    private String description;
}
