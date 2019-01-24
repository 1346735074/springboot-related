package com.demo.ant.common;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/10 10:39
 * @description: 基础父类测试
 */
@Data
@Accessors(chain = true)
public class BaseEntity {
    private Long id;

}
