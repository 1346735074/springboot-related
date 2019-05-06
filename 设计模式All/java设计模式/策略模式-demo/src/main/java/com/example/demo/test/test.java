package com.example.demo.test;

import java.util.concurrent.*;

/**
 *
 *
 * @author zhaoyao
 * @version 1.0
 * @date 2018/11/26 12
 * @description
 */
public class test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //定义Callable, 返回一个结果
        Callable<Integer> task = ()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 5;
        };
        Future<Integer> future = executorService.submit(task);
        Integer result = future.get();
        System.out.println(result);




        executorService.execute(new Runnable() {

            @Override
            public void run() {


                    System.out.println("aa");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            }
        });
        System.out.println("123123");

    }
}
