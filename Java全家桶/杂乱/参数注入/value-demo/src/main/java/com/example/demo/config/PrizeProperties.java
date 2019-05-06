package com.example.demo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 奖品配置
 *
 * @author zhaoyao
 * @version 1.0
 * @date 2019-01-15
 */
@Data
@Component
public class PrizeProperties {

//    @Value("data.person1")
//    private Map<String, String> person = new HashMap<>();

//    @Value("${festival.prize}")
//    private Map<String, Prize> map = new HashMap<>();

//    @Value("${acme.map}")
//    private Map<String, String> map = new HashMap<>();


//    @Value("${data.list}")
//    private List<String> urls = new ArrayList<>();

//    @Value("${data.listPrize}")
//    private List<Prize> listPrize = new ArrayList<>();

    @Value("${data.list1}")
    private List<String> urls1 = new ArrayList<>();

    @Value("${aaa.url}")
    private String url;

    @PostConstruct
    public void init(){
        System.out.println("123");
    }

    @Data
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Prize{
        /**
         * 开始时间
         */
        private String prizeStartTime;

        /**
         * 结束时间
         */
        private String prizeEndTime;

        /**
         * 开关
         */
        private Boolean isSwitch;
    }

}
