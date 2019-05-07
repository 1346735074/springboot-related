package com.zto.dayun.utils;

import com.zto.dayun.enums.EnumStatus;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Auther: ZHAOYAO
 * @Date: 2018/9/29 17:17
 * @Description:
 */
public class EnumFindHelper {

    /**
     * 根据code获取去value
     * @param c 枚举类型.class
     * @param code 枚举key
     * @param <E> 枚举类型
     * @param <K> key类型
     * @return
//     */
//    public static<E extends Enum<E>, K> Object getVelByCode(Class<E> c, K code){
//        try {
//            Class<E> class1 = (Class<E>) Class.forName(c.getCanonicalName());//加载类
//            EnumStatus[] rest  = (EnumStatus[]) class1.getMethod("values").invoke(new Object());//获取values方法执行
//
//            //获取get方法
//            List<Method> methods = new ArrayList<>();
//            Field[] fields = class1.getDeclaredFields();//获得属性
//            for (Field field : fields) {
//                if (field.getType().getName().equals(class1.getName()))continue;//为枚举里的值重新执行
//                if (field.getName().equals("$VALUES"))continue;//为$VALUES重新执行
//                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), class1,field.getName(),null);	//获得get方法
//                Method getMethod = pd.getReadMethod();//执行get方法返回一个Object
//                methods.add(getMethod);
//            }
//            if (!methods.get(0).getReturnType().equals(code.getClass())){
//                throw new IllegalArgumentException("枚举参数类型("+methods.get(0).getReturnType()
//                        +")和指定参数类型("+code.getClass()+")不匹配");
//            }
//            //比对
//            for(EnumStatus platformFree:rest){
//                if(code.equals(methods.get(0).invoke(platformFree))){
//                    return methods.get(1).invoke(platformFree);
//                }
//            }
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IntrospectionException e) {
//            e.printStackTrace();
//        }
//        throw new IllegalArgumentException("未知的枚举类型：" + code + ",请核对" + c.getSimpleName());
//    }
//
//    public static void main(String[] args) {
//        System.out.println(getVelByCode(EnumStatus.class,1));
//    }
}
