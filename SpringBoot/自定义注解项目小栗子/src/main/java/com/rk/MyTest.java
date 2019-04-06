package com.rk;

@MyComponent(value = "my is boy")
public class MyTest {

    @FieldAnnotations(value = "创建一个自定义注解 - 作用于域")
    private String userName;

    //注解到
    @MethodType(methodType = MethodType.MethodTypeEnum.TYPE2)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
