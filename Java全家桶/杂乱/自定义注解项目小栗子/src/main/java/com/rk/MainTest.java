package com.rk;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainTest {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        Class<MyTest> testClass = MyTest.class;

        csClass(testClass);
        cs(testClass);
        csField(testClass);
    }

    /**
     * 获取类注解
     *
     * @param testClass
     */
    public static void csClass(Class<MyTest> testClass) {
        //因为注解是作用于类上面的，所以可以通过isAnnotationPresent来判断是否是一个
        //有MyComponent注解的类
        if (testClass.isAnnotationPresent(MyComponent.class)) {
            System.out.println("this is a Annotations class");
            //通过getAnnotation可以获取注解对象
            MyComponent myComponent = testClass.getAnnotation(MyComponent.class);
            if (myComponent != null) {
                System.out.println("value:" + myComponent.value());
            } else {
                System.out.println("null");
            }
        } else {
            System.out.println("this is not Annotations class");
        }
    }

    /**
     * 获取方法注解
     *
     * @param testClass
     * @throws NoSuchMethodException
     */
    public static void cs(Class<MyTest> testClass) throws NoSuchMethodException {
        //因为是注解到method上的，所以首先要获取这个方法
        Method method = testClass.getDeclaredMethod("getUserName");
        //判断这个方法上是否有这个注解
        if (method.isAnnotationPresent(MethodType.class)) {
            System.out.println("this is a method Annotation");

            //如果有这个注解，则获取注解类
            MethodType methodType = (MethodType) method.getAnnotation(MethodType.class);
            if (methodType != null) {
                if (MethodType.MethodTypeEnum.TYPE1.equals(methodType.methodType())) {
                    System.out.println("this is TYPE1");
                } else {
                    System.out.println("this is TYPE2");
                }
            }
        } else {
            System.out.println("this is not  a method Annotation");
        }
    }

    /**
     * 创建一个自定义注解 - 作用于域
     *
     * @param testClass
     */
    public static void csField(Class<MyTest> testClass) throws NoSuchFieldException, IllegalAccessException {
        MyTest test = new MyTest();
        //因为是注解到Field上的，所以首先要获取这个字段
        Field field = testClass.getDeclaredField("userName");
        //判断这个Field上是否有这个注解
        if (field.isAnnotationPresent(FieldAnnotations.class)) {
            System.out.println("this is a field Annotation");

            //如果有这个注解，则获取注解类
            FieldAnnotations fieldAnnotations = (FieldAnnotations) field.getAnnotation(FieldAnnotations.class);
            if (fieldAnnotations != null) {
                //通过反射给私有变量赋值
                field.setAccessible(true);
                field.set(test, fieldAnnotations.value());
                System.out.println("value:" + test.getUserName());
            }
        } else {
            System.out.println("this is not  a field Annotation");
        }
    }

    ;
}