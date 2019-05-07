package com.example.demo.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoyao
 * @version 1.0
 * @date 2019-01-15
 */
@Slf4j
@Component
public class StringRedisTemplateTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    // 这个*一定要加，否则无法模糊查询
    public static final String PREFIX = "test*";

    public void test1() {
//        String prefix = String.format(USER_CARDS, AppContext.getSellerId(), "*");
//        Set<String> keys = stringRedisTemplate.keys(prefix);

        // 获取redis中以某些字符串为前缀的KEY列表
        Set<String> keys = stringRedisTemplate.keys(PREFIX);
        for (String key : keys) {
            System.out.println(key);
        }


    }

    public void stringList(){
        // key 不存在会返回null
        String test4 = stringRedisTemplate.opsForValue().get("test123456");
        System.out.println(test4);

        // key 不存在会返回size()为0的set集合
        Set<String> red_1231 = stringRedisTemplate.opsForSet().members("test-set213132132");
        for (String str : red_1231){
            System.out.println(str);
        }

        // key 不存在会返回felse  值不存在会返回felse
        Boolean red_123 = stringRedisTemplate.opsForSet().isMember("test-set", "1");
        System.out.println(red_123);
    }

    public void map(){
        String key = "map-test";
        stringRedisTemplate.opsForHash().put(key, "key1", "234");
        Map<Object, Object> map = stringRedisTemplate.opsForHash().entries(key);
        log.info("map");
    }


    public void test() {

        String test11111 = stringRedisTemplate.opsForValue().get("test11111");


        //向redis里存入数据和设置缓存时间
        stringRedisTemplate.opsForValue().set("test", "100", 60 * 10, TimeUnit.SECONDS);

        //val做-1操作
        Long test5 = stringRedisTemplate.boundValueOps("test").increment(-1);

        //根据key获取缓存中的val
        String test4 = stringRedisTemplate.opsForValue().get("test");

        //val +1
        Long test3 = stringRedisTemplate.boundValueOps("test11").increment(-1);
        stringRedisTemplate.expire("test11", 1, TimeUnit.DAYS);

        Long test311 = stringRedisTemplate.boundValueOps("test1").increment(1);

        //val +1
        Long test31 = stringRedisTemplate.boundValueOps("test1").increment(1);

        //根据key获取过期时间
        Long test2 = stringRedisTemplate.getExpire("test");

        //根据key获取过期时间并换算成指定单位
        Long test1 = stringRedisTemplate.getExpire("test", TimeUnit.SECONDS);

        //根据key删除缓存
        Boolean test = stringRedisTemplate.delete("test");

        //检查key是否存在，返回boolean值
        Boolean aBoolean = stringRedisTemplate.hasKey("546545");

        //向指定key中存放set集合
        Long red_1233 = stringRedisTemplate.opsForSet().add("red_123", "1", "2", "3");
        String[] array = new String[2];
        array[0] = "123";
        array[1] = "23";
        Long s = stringRedisTemplate.opsForSet().add("array", array);

        Set<String> set = new HashSet<>();
        set.add("123");
        set.add("342");
        String[] strings = set.stream().toArray(String[]::new);
        Long s1 = stringRedisTemplate.opsForSet().add("array1", strings);

        //设置过期时间
        Boolean red_1232 = stringRedisTemplate.expire("red_123", 1000, TimeUnit.MILLISECONDS);

        //根据key查看集合中是否存在指定数据
        Boolean red_123 = stringRedisTemplate.opsForSet().isMember("red_123", "1");
        Boolean red_12311 = stringRedisTemplate.opsForSet().isMember("red_123", "111111111111");

        //根据key获取set集合
        Set<String> red_1231 = stringRedisTemplate.opsForSet().members("red_123");
        Set<String> red_12312312313 = stringRedisTemplate.opsForSet().members("red_12312312313");

        red_1231.stream().forEach(System.out::println);
        log.info("123 user={}", new User("asdf", "asf"));
    }

    @Data
    @AllArgsConstructor
    public static class User {
        private String name;
        private String pwd;
    }
}
