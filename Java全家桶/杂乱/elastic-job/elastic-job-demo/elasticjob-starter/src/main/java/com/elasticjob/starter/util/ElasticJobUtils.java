package com.elasticjob.starter.util;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;

/**
 * @author purgeyao
 * @since 1.0
 */
public class ElasticJobUtils {

    /**
     * 获取 {@link LiteJobConfiguration} 对象
     *
     * @param jobClass               定时器实现类
     * @param jobName                定时器名称
     * @param cron                   定时参数
     * @param shardingTotalCount     作业分片总数
     * @param shardingItemParameters 当前参数
     * @param jobParameters          作业自定义参数
     * @return {@link LiteJobConfiguration}
     */
    public static LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> jobClass,
                                                               final String jobName,
                                                               final String cron,
                                                               final int shardingTotalCount,
                                                               final String shardingItemParameters,
                                                               final String jobParameters) {
        // 定义作业核心配置
        JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration
                .newBuilder(jobName, cron, shardingTotalCount)
                .shardingItemParameters(shardingItemParameters)
                .jobParameter(jobParameters)
                .build();

        // 定义SIMPLE类型配置
        SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig, jobClass.getCanonicalName());

        // 定义Lite作业根配置
        return LiteJobConfiguration.newBuilder(simpleJobConfig).overwrite(true).build();
    }
}
