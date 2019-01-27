package com.example.agency.test;

import com.example.agency.daili.SaleProxy;
import com.example.agency.dongtaidaili.MyInvocationHandler;
import com.example.agency.service.HouseSale;
import com.example.agency.service.impl.HouseOfJack;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * @auther: YAO
 * @date: 2018/10/30 09:34
 * @description:
 */
public class Market {

    @Test
    public void daili(){
        System.out.println("老子有钱，要买房");
        //创建代理人
        SaleProxy xiaoZhang = new SaleProxy();
        xiaoZhang.sale();
    }

    @Test
    public void dongTaiDaiLi(){
        //创建实现类
        HouseOfJack houseOfJack = new HouseOfJack();
        System.out.println("老子有钱，要买房");
        //创建代理类（传入实现类）
        MyInvocationHandler saleProxy = new MyInvocationHandler(houseOfJack);

        //newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
        //loader：被代理对象所使用的类加载器
        //interfaces：被代理类实现的接口，可以为多个
        //h：被重定向时的句柄对象
        HouseSale houseSale = (HouseSale) Proxy.newProxyInstance(houseOfJack.getClass().getClassLoader(),
                houseOfJack.getClass().getInterfaces(), saleProxy);
        houseSale.sale();
    }
}
