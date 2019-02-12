package com.demo.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author zhaoyao
 * @version 1.0
 * @date 2019-02-12
 */
@Data
@ToString
@Component
public class User {

    private String name;

    private String id;

    private String age;

    private String sex;
}
