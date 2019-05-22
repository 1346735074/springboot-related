package com.elasticjob.starter.parser;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.elasticjob.starter.annotation.ElasticJobConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author purgeyao
 * @since 1.0
 */
@Slf4j
public class JobConfParser implements ApplicationContextAware {

    private Environment environment;

    @Resource
    private ZookeeperRegistryCenter zookeeperRegistryCenter;

    private List<String> jobTypeNameList = Arrays.asList("SimpleJob", "DataflowJob", "ScriptJob");

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        environment = applicationContext.getEnvironment();

        Map<String, Object> beanMap = applicationContext.getBeansWithAnnotation(ElasticJobConfig.class);
        beanMap.forEach((k, confBean) -> {
            Class<?> clz = confBean.getClass();
            // 解决CGLIB代理问题
            String jobTypeName = clz.getInterfaces()[0].getSimpleName();
            if (!jobTypeNameList.contains(jobTypeName)) {
                jobTypeName = clz.getSuperclass().getInterfaces()[0].getSimpleName();
                clz = clz.getSuperclass();
            }

            ElasticJobConfig conf = AnnotationUtils.findAnnotation(clz, ElasticJobConfig.class);


            // 获取注解信息
            // 构建JobCoreConfiguration对象
//            LiteJobConfiguration liteJobConfiguration = ElasticJobUtils
//                    .getLiteJobConfiguration(confBean.getClass(), "", "",
//                            "", "", "");

            // 不同类型的任务配置处理

        });

    }
}
