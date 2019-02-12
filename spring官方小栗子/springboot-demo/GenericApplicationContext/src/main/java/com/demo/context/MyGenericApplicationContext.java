package com.demo.context;

import com.demo.entity.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author zhaoyao
 * @version 1.0
 * @date 2019-02-12
 */
@Component
public class MyGenericApplicationContext {

    public void test(){
        BeanDefinitionBuilder beanBuilder = BeanDefinitionBuilder.rootBeanDefinition(User.class);
    }
}
