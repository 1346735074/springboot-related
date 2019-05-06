//package com.example.demo.Strategy1;
//
//import com.example.demo.Strategy1.enums.StrategyEnum;
//
//import static com.example.demo.Strategy1.enums.StrategyEnum.ADD;
//import static com.example.demo.Strategy1.enums.StrategyEnum.MUL;
//import static com.example.demo.Strategy1.enums.StrategyEnum.SUB;
//
///**
// *
// *
// * @author zhaoyao
// * @version 1.0
// * @date 2018/11/26 21
// * @description
// */
//public class Client {
//
//    public static void main(String[] args) {
//        int x = 10;
//        int y = 5;
//        //add
//        System.out.println(new Context(ADD).getResult(x, y));
//        // sub
//        System.out.println(new Context(SUB).getResult(x, y));
//        // mul
//        System.out.println(new Context(MUL).getResult(x, y));
//    }
//}
