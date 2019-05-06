package com.example.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @auther: YAO
 * @date: 2018/11/2 10:04
 * @description: 作为一名优秀的开发人员，
 * 我们应该编写一些测试来确保我们的网关正在做我们所期望的事情。
 * 在大多数情况下，我们希望限制对外部资源的依赖，特别是在单元测试中，
 * 因此我们不应该依赖于HTTPBin。这个问题的一个解决方案是使路由中的URI可配置，
 * 以便在需要时可以轻松地更改URI。
 */
@Data
@ConfigurationProperties
public class UriConfiguration {

    private String httpbin = "http://httpbin.org:80";

}
