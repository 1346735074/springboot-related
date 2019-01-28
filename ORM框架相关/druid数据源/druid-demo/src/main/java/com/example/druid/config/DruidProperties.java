package com.example.druid.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @auther: YAO
 * @date: 2018/11/6 16:29
 * @description:
 */
@Data
@ConfigurationProperties(prefix = "druid")
public class DruidProperties {
    private String url;
    private String username;
    private String password;
    private String driverClass;
    private int maxActive;//最大连接数
    private int minIdle;//最小连接数
    private int initialSize;//初始化数量和
    private boolean testOnBorrow;
    private Long timeBetweenEvictionRunsMillis;//心跳
}
