package com.example.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @auther: YAO
 * @date: 2018/11/5 14:01
 * @description:
 */
@Data
@ConfigurationProperties(prefix = "redisson")
public class RedissonProperties {
    private int timeout = 3000;

    private String address;

    private String password;

    private int connectionPoolSize = 64;

    private int connectionMinimumIdleSize=10;

    private int slaveConnectionPoolSize = 250;

    private int masterConnectionPoolSize = 250;

    private String[] sentinelAddresses;

    private String masterName;
}
