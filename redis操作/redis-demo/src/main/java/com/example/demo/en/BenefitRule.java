package com.example.demo.en;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jasonbiao
 * @Description:
 * @Date Create In 14:35 2018/10/19
 * @Modified By:
 */
@NoArgsConstructor
@Data
@ToString
@Slf4j
public class BenefitRule {

    private static final Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    /**
     * 权益id
     */
    private String benefitId;

    /**
     * 奖金池
     */
    private String benefitGroup;

    /**
     * 初始化库存--
     */
    private int initInventory;

    /**
     * 总数量
     */
    private int totalInventory;

    /**
     * 扩展
     */
    private String attributes;

    /**
     * 默认中奖概率
     */
    private double defWinRate;

    /**
     * 增量规则
     */
    private List<IncrRule> incrRules;

    /**
     * 奖品类型
     */
    private String awardType;

    /**
     * 奖品ID
     */
    private String awardId;

    @NoArgsConstructor
    @Data
    public static class IncrRule {
        private Date startDate;
        private Date endDate;
        /**如果当前时间在开始时间和结束时间之间，则用此替换默认中奖概率进行计算*/
        private double winRate;
        private int maxInventory;
    }

    public static void main(String[] args) {
        //https://taoquan.taobao.com/coupon/unify_apply.htm?sellerId=3963690401&activityId=66d05c2c3040428baf2216793a314da0
        BenefitRule benefitRule = new BenefitRule();

        // 奖品ID
        benefitRule.setAwardId("66F81559A366A6F7930C293958A9640C");

        // 奖金池
        benefitRule.setBenefitGroup("sharePrize");

        // 初始化库存--
        benefitRule.setInitInventory(7000);

        // 总数量
        benefitRule.setTotalInventory(7000);

        // 扩展 {'money': '10.10'}
        benefitRule.setAttributes("{'money':'0.58'}");

        // 默认中奖概率
        benefitRule.setDefWinRate(6.25D/100);

        // 奖品类型 coupon  mouCommonFpRedEnvelope
//        benefitRule.setAwardType("coupon");
        benefitRule.setAwardType("mouCommonFpRedEnvelope");

        // 权益id(红包使用)
        benefitRule.setBenefitId("21316002");


        // 增量规则
//        ArrayList<IncrRule> objects = new ArrayList<>();
//        IncrRule incrRule = new IncrRule();
//        incrRule.setStartDate(new Date(new java.util.Date().getTime()));
//        incrRule.setEndDate(new Date(new java.util.Date().getTime()));
//        incrRule.setWinRate(0.0D);
//        incrRule.setMaxInventory(0);
//        objects.add(incrRule);
//        benefitRule.setIncrRules(objects);

        log.info("BenefitRule  =   {}",GSON.toJson(benefitRule));
    }





}
