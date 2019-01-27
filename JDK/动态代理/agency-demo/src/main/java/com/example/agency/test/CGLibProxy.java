package com.example.agency.test;

import com.example.agency.Cglib.HelloConcrete;
import com.example.agency.Cglib.MyMethodInterceptor;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @auther: YAO
 * @date: 2018/10/30 11:57
 * @description:
 */
public class CGLibProxy {

    @Test
    public void CGLib(){
//        @para1 o ：代理对象本身
//        @para2 method ： 被拦截的方法对象
//        @para3 objects：方法调用入参
//        @para4 methodProxy：用于调用被拦截方法的方法代理对象

        //创建cglib Enhancer
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloConcrete.class);//代理对象本身
        enhancer.setCallback(new MyMethodInterceptor());//传入拦截器类

        HelloConcrete helloConcrete = (HelloConcrete) enhancer.create();//代理创建原始对象

        System.out.println(helloConcrete.sayHello("开始使用了"));//调用代理对象本身方法
        System.out.println(helloConcrete.getClass().getName());
        System.out.println(helloConcrete.getClass().getSuperclass().getName());
    }
}
