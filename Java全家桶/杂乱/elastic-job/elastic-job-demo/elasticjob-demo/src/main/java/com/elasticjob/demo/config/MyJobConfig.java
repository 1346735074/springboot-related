package com.elasticjob.demo.config;

import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.elasticjob.demo.scheduled.MySimpleJob;
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
public class MyJobConfig {

    // 自定义参数
    private final String jobParameters = "parameter";

    @Resource
    private ZookeeperRegistryCenter regCenter;

    @Resource
    private JobEventConfiguration jobEventConfiguration;

    @Bean(initMethod = "init")
    public JobScheduler mySimpleJobScheduler(final MySimpleJob mySimpleJob,
                                             @Value("${myJob.cron}") final String cron,
                                             @Value("${myJob.shardingTotalCount}") final int shardingTotalCount,
                                             @Value("${myJob.shardingItemParameters}") final String shardingItemParameters) {

        LiteJobConfiguration liteJobConfiguration = LiteJobUtils.getLiteJobConfiguration(mySimpleJob.getClass(), cron,
                shardingTotalCount, shardingItemParameters, jobParameters);
        return new SpringJobScheduler(mySimpleJob, regCenter, liteJobConfiguration, jobEventConfiguration);
    }

}
