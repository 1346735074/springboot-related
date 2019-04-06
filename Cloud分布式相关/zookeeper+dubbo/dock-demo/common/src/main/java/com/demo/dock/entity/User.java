package com.demo.dock.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/18 12:39
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -4698181562456779906L;
    private String name;
    private String pwd;
}
