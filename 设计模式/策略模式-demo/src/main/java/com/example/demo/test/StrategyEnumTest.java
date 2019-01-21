package com.example.demo.test;

import com.example.demo.enums.StrategyEnum;

/**
 *
 *
 * @author zhaoyao
 * @version 1.0
 * @date 2018/11/26 17
 * @description
 */
public class StrategyEnumTest {
    public static void main(String[] args) {
        System.out.println( StrategyEnum.ADD.exec(2,4));
        System.out.println( StrategyEnum.SUB.exec(2,4));
        System.out.println( StrategyEnum.MUTI.exec(2,4));
        StrategyEnum.ADD.exec(1,1);
    }
}
