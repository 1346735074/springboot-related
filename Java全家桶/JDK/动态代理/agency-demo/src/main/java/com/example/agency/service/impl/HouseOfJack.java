package com.example.agency.service.impl;

import com.example.agency.service.HouseSale;

/**
 * @auther: YAO
 * @date: 2018/10/30 09:44
 * @description: 房屋销售
 */
public class HouseOfJack implements HouseSale {

    @Override
    public void sale() {
        System.out.println("给我100万，房子归你");
    }
}
