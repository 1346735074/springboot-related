package com.demo.bootstart;

import com.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 *
 * @author zhaoyao
 * @version 1.0
 * @date 2019-02-12
 */
@Slf4j
@SpringBootApplication
public class GenericApplicationContextBootstart {

    public static void main(String[] args) {
        SpringApplication.run(GenericApplicationContextBootstart.class, args);
        BeanDefinitionBuilder beanBuilder = BeanDefinitionBuilder.rootBeanDefinition(User.class);
        log.info(beanBuilder.toString());
    }
}
