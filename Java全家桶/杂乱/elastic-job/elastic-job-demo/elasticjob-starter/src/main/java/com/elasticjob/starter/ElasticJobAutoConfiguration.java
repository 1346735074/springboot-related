package com.elasticjob.starter;

import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.elasticjob.starter.factory.SpringJobSchedulerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author purgeyao
 * @since 1.0
 */
@Configuration
@EnableConfigurationProperties(ElasticJobProperties.class)
public class ElasticJobAutoConfiguration {

    @Bean
    public SpringJobSchedulerFactory springJobSchedulerFactory(
            ElasticJobProperties elasticJobProperties,
            ZookeeperRegistryCenter regCenter,
            JobEventConfiguration jobEventConfiguration) {
        return new SpringJobSchedulerFactory(elasticJobProperties, regCenter, jobEventConfiguration);
    }
}
