package com.example.springcache.dao;

import com.example.springcache.SpringCacheApplicationTests;
import com.example.springcache.entity.Book;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

/**
 * @auther: YAO
 * @date: 2018/11/2 10:56
 * @description:
 */
@Component
@Slf4j
public class SimpleBookRepositoryTest extends SpringCacheApplicationTests {

    @Autowired
    private SimpleBookRepository simpleBookRepository;

    @Test
    public void getByIsbn() {

        Gson gson = new Gson();
        Book byIsbn = simpleBookRepository.getByIsbn("123");
        log.info(gson.toJson(byIsbn));
        log.info(gson.toJson(simpleBookRepository.getByIsbn("123")));
        log.info(gson.toJson(simpleBookRepository.getByIsbn("123")));
        log.info(gson.toJson(simpleBookRepository.getByIsbn("换一个试一试")));
        log.info(gson.toJson(simpleBookRepository.getByIsbn("换一个试一试")));
        log.info(gson.toJson(simpleBookRepository.getByIsbn("123")));
        Assert.assertTrue(byIsbn != null);
    }
}