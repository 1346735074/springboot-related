package com.example.xmlconvertjson.config;

import com.example.xmlconvertjson.listener.ResourceListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/16 13:05
 * @description:
 */
@Configuration
@Slf4j
public class ResourceConfig {

    //文件目录
    private static String path = "E:\\项目\\wjj";

    @Bean
    public ResourceListener getResourceListener() throws IOException {
        ResourceListener resourceListener = new ResourceListener(path);
        Path p = Paths.get(path);
        p.register(resourceListener.getWs(), StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_CREATE);
        log.info(">>>>>>>文件监控已启动...");
        return resourceListener;
    }

}
