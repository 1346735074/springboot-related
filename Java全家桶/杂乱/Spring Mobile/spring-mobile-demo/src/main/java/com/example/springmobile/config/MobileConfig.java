package com.example.springmobile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mobile.device.DeviceHandlerMethodArgumentResolver;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @auther: YAO
 * @date: 2018/11/2 14:12
 * @description:
 */
@Configuration
@EnableWebMvc
public class MobileConfig extends WebMvcConfigurerAdapter {
    @Bean
    public DeviceResolverHandlerInterceptor
    deviceResolverHandlerInterceptor() {
        return new DeviceResolverHandlerInterceptor();
    }

    @Bean
    public DeviceHandlerMethodArgumentResolver
    deviceHandlerMethodArgumentResolver() {
        return new DeviceHandlerMethodArgumentResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(deviceResolverHandlerInterceptor());
    }

    @Override
    public void addArgumentResolvers(
            List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(deviceHandlerMethodArgumentResolver());
    }
}
