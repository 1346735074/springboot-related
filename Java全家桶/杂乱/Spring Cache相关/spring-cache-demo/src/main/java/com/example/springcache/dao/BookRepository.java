package com.example.springcache.dao;

import com.example.springcache.entity.Book;

/**
 * @auther: YAO
 * @date: 2018/11/2 10:44
 * @description:
 */
public interface BookRepository {
    Book getByIsbn(String isbn);
}
