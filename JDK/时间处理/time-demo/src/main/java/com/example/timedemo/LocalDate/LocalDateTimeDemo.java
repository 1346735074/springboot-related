package com.example.timedemo.LocalDate;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 *
 * @author zhaoyao
 * @version 1.0
 * @date 2019-01-30
 */
public class LocalDateTimeDemo {


    @Test
    public void strTurnLocalDateTime(){
        // 2007-12-03T10:15:30 -> LocalDateTime
        LocalDateTime now = LocalDateTime.parse("2007-12-03T10:15:30");
        System.out.println(now);
    }

    @Test
    public void localDateTime(){
        // 2019-01-30T14:15:29.765
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        // 2019-01-30
        String format = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(format);
    }

}
