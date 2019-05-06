package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by nuonuo
 * 2018/8/22 下午 5:35
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    UserArgumentResolver userArgumentResolver;

    /**
     * 跳转controller携带参数
     *
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userArgumentResolver);
    }
}
