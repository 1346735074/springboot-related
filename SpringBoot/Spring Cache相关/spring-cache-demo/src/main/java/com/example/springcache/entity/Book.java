package com.example.springcache.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther: YAO
 * @date: 2018/11/2 10:42
 * @description: 书实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private String isbn;

    private String title;

}
