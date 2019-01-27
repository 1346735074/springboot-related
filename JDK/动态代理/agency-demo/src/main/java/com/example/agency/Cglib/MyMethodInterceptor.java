package com.example.agency.Cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @auther: YAO
 * @date: 2018/10/30 11:57
 * @description:
 */
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //System.out.println("class of o : " + o.getClass());
        System.out.println("这是拦截器");

        return methodProxy.invokeSuper(o, objects);
    }
}
