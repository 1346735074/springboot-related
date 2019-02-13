package com.demo.context;

import com.demo.controller.UserController;
import com.demo.entity.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
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

    }


    public void test1(){
        //将applicationContext转换为ConfigurableApplicationContext
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) SpringContextUtil.getApplicationContext();

        // 获取bean工厂并转换为DefaultListableBeanFactory
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();

        // 通过BeanDefinitionBuilder创建bean定义
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserController.class);

        // 设置属性userService,此属性引用已经定义的bean:userService,这里userService已经被spring容器管理了.
        beanDefinitionBuilder.addPropertyReference("userService", "userService");

        // 注册bean
        defaultListableBeanFactory.registerBeanDefinition("userController", beanDefinitionBuilder.getRawBeanDefinition());


        UserController userController = (UserController) SpringContextUtil.getBean("userController");

        userController.toAction("动态注册生成调用");
    }
}
