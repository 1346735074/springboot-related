package com.elasticjob.starter;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @author purgeyao
 * @since 1.0
 */
@Data
@ToString
@ConfigurationProperties(ElasticJobProperties.PREFIX)
public class ElasticJobProperties {

    public static final String PREFIX = "spring.elasticjob.scheduled";

    private Map<String, JobConfig> jopMap = new HashMap<>();

    @Data
    @ToString
    public static class JobConfig{

        private String jobName;

        private String cron;

        private int shardingTotalCount = 1;

        private String shardingItemParameters;

        private String jobParameters;
    }
}
