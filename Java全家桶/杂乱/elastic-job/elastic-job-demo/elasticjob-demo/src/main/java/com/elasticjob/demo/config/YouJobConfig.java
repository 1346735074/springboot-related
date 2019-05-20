package com.elasticjob.demo.config;
//
//import com.dangdang.ddframe.job.lite.api.JobScheduler;
//import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
//import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
//import com.example.elasticjobdemo.scheduled.YouSimpleJob;
//import com.example.elasticjobdemo.util.LiteJobUtils;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.Resource;
//
///**
// * @author purgeyao
// * @since 1.0
// */
//@Configuration
//public class YouJobConfig {
//
//    @Resource
//    private ZookeeperRegistryCenter regCenter;
//
//    @Bean(initMethod = "init")
//    public JobScheduler youSimpleJobScheduler(final YouSimpleJob youSimpleJob,
//                                           @Value("${simpleJob.cron}") final String cron,
//                                           @Value("${simpleJob.shardingTotalCount}") final int shardingTotalCount,
//                                           @Value("${simpleJob.shardingItemParameters}") final String shardingItemParameters) {
//
//        return new SpringJobScheduler(youSimpleJob, regCenter,
//                LiteJobUtils.getLiteJobConfiguration(youSimpleJob.getClass(), cron,
//                        shardingTotalCount, shardingItemParameters, null));
//    }
//
//}
