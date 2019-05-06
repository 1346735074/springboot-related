package com.example.gateway;

import com.example.gateway.config.UriConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
@EnableConfigurationProperties(UriConfiguration.class)
//@SpringCloudApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder,UriConfiguration uriConfiguration){
        String httpUri = uriConfiguration.getHttpbin();
        return builder.routes()
                .route(p -> p
                        .path("/get") //请求路径
                        .filters(f -> f.addRequestHeader("Hello","World")) //添加request 头部参数
                        .uri(httpUri)) //转发请求到指定地址
                //配置hystrix熔断机制
                .route(p -> p
                        .host("*.hystrix.com") //当请求的host有“*.hystrix.com”，都会进入该router
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("mycmd")
                                        .setFallbackUri("forward:/fallback")))
                        .uri(httpUri))

                .build();
    }

    /**
     * 熔断返回
     * Mono是一个Reactive stream，对外输出一个“fallback”字符串。
     * @return
     */
    @RequestMapping("/fallback")
    public Mono<String> fallback(){
        return Mono.just("fallback");
    }
}
