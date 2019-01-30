package com.example.timedemo.LocalDate;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @author zhaoyao
 * @version 1.0
 * @date 2019-01-30
 */
public class LocalDateDemo {

    public static void main(String[] args) {

    }

    @Test
    public void localDate() {

        // 获取今天的日期
        LocalDate today = LocalDate.now();

        // 今天是几号
        int dayofMonth = today.getDayOfMonth();

        // 今天是周几（返回的是个枚举类型，需要再getValue()）
        int dayofWeek = today.getDayOfWeek().getValue();

        // 今年是哪一年
        int dayofYear = today.getDayOfYear();

        // 根据字符串取：
        LocalDate endOfFeb = LocalDate.parse("2018-02-28");
        // 严格按照yyyy-MM-dd验证，02写成2都不行，当然也有一个重载方法允许自己定义格式

        System.out.println("今天是几号:" + dayofMonth + " 今天是周几:" + dayofWeek + " 今年是哪一年" + dayofYear);
    }


    @Test
    public void temporal(){

        // 获取今天的日期
        LocalDate today = LocalDate.now();

        // 取本月第1天：2019-01-01
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfThisMonth);

        // 取本月第2天：
        LocalDate secondDayOfThisMonth = today.withDayOfMonth(2);
        System.out.println(secondDayOfThisMonth);

        // 取本月最后一天，再也不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayOfThisMonth);

        // 取下一天：
        LocalDate firstDayOfNextMonth = lastDayOfThisMonth.plusDays(1);
        System.out.println(firstDayOfNextMonth);

        // 取2019年1月第一个周一：
        LocalDate firstMondayOf2017 = LocalDate.parse("2017-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstMondayOf2017);

    }

    /**
     * LocalDate的格式化不要用SimpleDateFormat的方法
     */
    @Test
    public void simpleDateFormat(){
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String text = today.format(formatters);
        System.out.println(text);
    }

    /**
     * 构造时间：
     */
    @Test
    public void parse() {

        // 00:00:00
        LocalTime zero = LocalTime.of(0, 0, 0);
        System.out.println(zero);

        // 12:00:00
        LocalTime mid = LocalTime.parse("12:00:00");
        System.out.println(mid);

    }
}
