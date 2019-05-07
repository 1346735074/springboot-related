package com.demo.ant.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/15 15:26
 * @description: 定时任务
 */
@Configuration
@EnableScheduling // 启用定时任务
@Slf4j
public class SchedulingConfig {

    @Scheduled(cron = "0/20 * * * * ?") // 每20秒执行一次
    public void scheduler() {
        log.info(">>>>>>>>>>>>> scheduled定时任务(每20秒执行一次) ... ");
    }

}
