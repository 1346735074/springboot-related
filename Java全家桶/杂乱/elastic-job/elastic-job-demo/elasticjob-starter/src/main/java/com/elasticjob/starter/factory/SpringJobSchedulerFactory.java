package com.elasticjob.starter.factory;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.elasticjob.starter.ElasticJobProperties;
import com.elasticjob.starter.util.ElasticJobUtils;

/**
 * {@link SpringJobScheduler} 构建
 *
 * @author purgeyao
 * @since 1.0
 */
public class SpringJobSchedulerFactory {

    private ElasticJobProperties elasticJobProperties;

    private ZookeeperRegistryCenter regCenter;

    private JobEventConfiguration jobEventConfiguration;

    public SpringJobSchedulerFactory(
            ElasticJobProperties elasticJobProperties,
            ZookeeperRegistryCenter regCenter,
            JobEventConfiguration jobEventConfiguration) {
        this.elasticJobProperties = elasticJobProperties;
        this.regCenter = regCenter;
        this.jobEventConfiguration = jobEventConfiguration;
    }

    /**
     * 获取{@link SpringJobScheduler} 对象
     *
     * @param simpleJob 实现SimpleJob类型
     * @param jobName   config job的名称
     * @param isEvent   是否开启历史轨迹
     * @return SpringJobScheduler
     */
    public SpringJobScheduler gerSpringJobScheduler(SimpleJob simpleJob, String jobName, Boolean isEvent) {

        ElasticJobProperties.JobConfig jobConfig = elasticJobProperties.getJopMap().get(jobName);

        LiteJobConfiguration liteJobConfiguration = ElasticJobUtils
                .getLiteJobConfiguration(simpleJob.getClass(), jobConfig.getJobName(),
                        jobConfig.getCron(), jobConfig.getShardingTotalCount(),
                        jobConfig.getShardingItemParameters(), jobConfig.getJobParameters());

        if (isEvent) {
            return new SpringJobScheduler(simpleJob, regCenter, liteJobConfiguration, jobEventConfiguration);
        }
        return new SpringJobScheduler(simpleJob, regCenter, liteJobConfiguration);
    }
}
