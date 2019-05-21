package com.elasticjob.demo.config;

import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.elasticjob.demo.scheduled.YouSimpleJob;
import com.elasticjob.starter.util.LiteJobUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author purgeyao
 * @since 1.0
 */
@Configuration
public class YouJobConfig {

    @Resource
    private ZookeeperRegistryCenter regCenter;

    @Bean(initMethod = "init")
    public JobScheduler youSimpleJobScheduler(final YouSimpleJob youSimpleJob,
                                           @Value("${youJob.cron}") final String cron,
                                           @Value("${youJob.shardingTotalCount}") final int shardingTotalCount,
                                           @Value("${youJob.shardingItemParameters}") final String shardingItemParameters) {

        LiteJobConfiguration liteJobConfiguration = LiteJobUtils.getLiteJobConfiguration(youSimpleJob.getClass(), cron,
                shardingTotalCount, null, null);
        return new SpringJobScheduler(youSimpleJob, regCenter, liteJobConfiguration);
    }

}
