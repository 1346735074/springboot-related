package com.example.springcache.dao;

import com.example.springcache.entity.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @auther: YAO
 * @date: 2018/11/2 10:46
 * @description: 为了演示这个栗子，我只做了一下线程的延迟操作，当作是查询数据库的时间
 */
@Component
public class SimpleBookRepository implements BookRepository {

    @Override
    @Cacheable("books") //开启缓存
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "一些书");
    }

    //不要在家里这样做
    private void simulateSlowService() {
        long time = 3000L;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
