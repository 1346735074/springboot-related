package com.example.lambdademo.supplier;

import java.util.function.Supplier;

/**
 *
 *
 * @author zhaoyao
 * @version 1.0
 * @date 2019-01-29
 */
public class SupplierDesignDemo {

    public static void main(String[] args) {

        // 待执行数据
        Supplier<String> message = supplyMessage();

        // 实际执行
        String hello = message.get();
        System.out.println(hello);
    }

    private static Supplier<String> supplyMessage() {
        System.out.println("supplier");
        return SupplierDesignDemo::getMessage;
    }

    private static String getMessage() {
        sleep(1000);
        return "Hello,World";
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
