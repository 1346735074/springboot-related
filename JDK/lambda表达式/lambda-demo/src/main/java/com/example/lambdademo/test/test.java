package com.example.lambdademo.test;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @auther: YAO
 * @date: 2018/10/31 16:19
 * @description:
 */
public class test {

    @Test
    public void test1(){
        //创建线程举例
        //原来写法
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("启动");
            }
        });
        //lambda写法
        Thread thread1 = new Thread(() -> System.out.println("启动"));
    }

    @Test
    public void test2(){
        //排序
        List<String> strings = Arrays.asList(new String[]{"b","c","a"});
        //匿名类写法
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        //lambda写法
        Collections.sort(strings, (str1,str2) -> str1.compareTo(str2));
        Collections.sort(strings, String::compareTo);
    }

    @Test
    public void test3(){

        //将列表中的字符串转换为全小写
        List<String> proNames = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
        //单语句写法
        List<String> lowercaseNames2 = proNames.stream()
                .map(name -> name.toLowerCase())
                .collect(Collectors.toList());
    }

    @Test
    public void test4(){
        //lambda表达式可使用的变量
        //变量waibu ：外部变量
        //变量chuandi ：传递变量
        //变量zidingyi ：内部自定义变量
        String waibu = "lambda";
        List<String> list = Arrays.asList(new String[]{"Ni", "Hao", "Lambda"});

        List<String> execStrs = list.stream().map(chundi -> {
            Long zidingyi = System.currentTimeMillis();
            return waibu + chundi + "-----:" + zidingyi;
        }).collect(Collectors.toList());

        execStrs.forEach(System.out::println);
    }

    @Test
    public void test5(){
        //Lists是Guava中的一个工具类
        ArrayList<Integer> nums = Lists.newArrayList(1, null, 3, 4, null, 6);
        //nums.stream()  创建Stream
        // .filter(num -> num != null) 转换Stream
        // .count()  聚合
        nums.stream().filter(num -> num != null).count();
    }

    @Test
    public void test6(){
        //遍历List
        List<String> list = new ArrayList<>(Arrays.asList("aa", "bb", "cc"));
        list.forEach(n -> System.out.println(n));
        list.forEach(System.out::println);

        //遍历Map
        Map<String, String> map = new HashMap<String, String>() {{
            put("key1", "value1");
            put("key2", "value2");
            put("key3", "value3");
        }};
        map.forEach((k,v)->System.out.println("Key:" + k + "-----Value:" + v));
        map.forEach((k,v)->{
            System.out.println("橙色");
            System.out.println("Key:" + k + "-----Value:" + v);
        });
        list.stream().count();
    }

    @Test
    public void test8(){

        List<String> list = Arrays.asList(new String[]{"Ni", "Hao", "Lambda"});
        //过滤不是(Ni) 打印
        list.stream().filter(item -> !item.equals("Ni")).forEach(System.out::println);
    }

    @Test
    public void test9(){
        //去掉重复的 distinct
        Stream.of(9,1,2,3,1,1,2,3,4,3).distinct().forEach(System.out::println);
        Stream.of("wr","qqq","wr").distinct().forEach(System.out::println);

        //
        List<String> list = Arrays.asList(new String[]{"Ni11", "12312", "123"});
        //map转为大写
        System.out.println("------------map转为大写------------");
        list.stream().map(item -> item.toUpperCase()).forEach(System.out::println);

        //peek在每个元素前面执行一个命令
        System.out.println("-----------peek在每个元素前面执行一个命令------------");
        list.stream().peek(s -> System.out.println(s)).forEach(System.out::println);

        //skip去掉指定的
        System.out.println("------------skip去掉指定的------------");
        list.stream().skip(1).forEach(System.out::println);


        //sorted排序 从小到大
        System.out.println("------------sorted排序------------");
        Stream.of(1, 9, 3, 4, 5).sorted().forEach(System.out::println);

        //collect收集为一个list集合
        System.out.println("------------collect收集为一个list集合------------");
        List<Integer> collect = Stream.of(1, 9, 3, 4, 5).sorted().collect(Collectors.toList());

    }


    @Test
    public void test10(){
        User user = new User("小米","123");
        User user1 = new User("小小","685");
        User user2 = new User("胖胖","324");
        List<User> users = Arrays.asList(user, user1, user2);
        //取出user里面的姓名装为一个list
        List<String> collect = users.stream().map(item -> item.getName()).collect(Collectors.toList());
        collect.forEach(System.out::println);


        List<String> collect1 = users.stream().map(User::getPwd).collect(Collectors.toList());
        collect1.forEach(System.out::println);
    }

    @Data
    @AllArgsConstructor
    private class User{
       private String name;
       private String pwd;
    }
}
