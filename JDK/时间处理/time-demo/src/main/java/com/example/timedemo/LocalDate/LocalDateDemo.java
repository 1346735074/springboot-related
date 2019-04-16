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
    public void temporal() {

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

        // 取上一天：
        LocalDate lastDayOfNextMonth = lastDayOfThisMonth.minusDays(1);
        System.out.println(lastDayOfNextMonth);

        // 取2019年1月第一个周一：
        LocalDate firstMondayOf2017 = LocalDate.parse("2017-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstMondayOf2017);

    }

    /**
     * LocalDate的格式化不要用SimpleDateFormat的方法
     */
    @Test
    public void simpleDateFormat() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String text = today.format(formatters);
        System.out.println(text);

        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        // 字符串转LocalDate
        LocalDate parse = LocalDate.parse("2017-01-07");
        System.out.println(parse);

        // 2019-02-20 00:00:00 -> LocalDate
        LocalDate parse1 = LocalDate.parse("2019-02-20 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(parse1);

        LocalDate parse2 = LocalDate.parse("2019-02-20");
        System.out.println(parse2);

        boolean equal = parse1.isEqual(parse2);
        System.out.println(equal);
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


    @Test
    public void compare() {
        LocalDate today = LocalDate.now();

        LocalDate parse = LocalDate.parse("2017-01-07");

        LocalDate parse1 = LocalDate.parse("2017-01-07");

        // 现在时间 compareTo 2017-01-07
        int i = today.compareTo(parse);

        // 2017-01-07 compareTo 现在时间
        int i1 = parse.compareTo(today);
        System.out.println("today.compareTo(parse):" + i + " parse.compareTo(today):" + i1);

        // 比较两个日期对象是否相等  相等:true
        boolean equal = today.isEqual(parse);
        boolean equal1 = parse.isEqual(parse1);
        System.out.println(equal + " " + equal1);

//        isBefore(ChronoLocalDate other)    boolean    比较当前对象日期是否在other对象日期之前
//        isAfter(ChronoLocalDate other)    boolean    比较当前对象日期是否在other对象日期之后
        // 比较当前对象日期是否在other对象日期之前
        boolean before = today.isBefore(parse);
        System.out.println(before);

        // 比较当前对象日期是否在other对象日期之后
        boolean after = today.isAfter(parse);
        System.out.println(after);


    }
}
