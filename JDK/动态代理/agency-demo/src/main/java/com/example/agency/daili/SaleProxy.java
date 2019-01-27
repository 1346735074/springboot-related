package com.example.agency.daili;

import com.example.agency.service.HouseSale;
import com.example.agency.service.impl.HouseOfJack;

/**
 * @auther: YAO
 * @date: 2018/10/30 09:45
 * @description: 销售代理
 */
public class SaleProxy implements HouseSale {

    private HouseOfJack jack = new HouseOfJack();

    @Override
    public void sale() {
        System.out.println("现有房源，欢迎选购！");
        jack.sale();
        System.out.println("恭喜这位爷！");
        System.out.println("成功卖出，收取佣金10%，美滋滋！");
    }
}
