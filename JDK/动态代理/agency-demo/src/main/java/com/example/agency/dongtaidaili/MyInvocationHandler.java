package com.example.agency.dongtaidaili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @auther: YAO
 * @date: 2018/10/30 09:40
 * @description:
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object houseHolder;

    public MyInvocationHandler(Object object){
        this.houseHolder = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("现有房源，欢迎选购！");
        //jack.sale();
        method.invoke(houseHolder,args);
        System.out.println("恭喜这位爷！");
        System.out.println("成功卖出，收取佣金10%，美滋滋！");
        return null;
    }
}