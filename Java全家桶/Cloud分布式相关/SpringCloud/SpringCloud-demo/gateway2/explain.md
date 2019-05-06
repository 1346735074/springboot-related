###Spring Cloud GateWay初体验

这篇文章讲述了如何简单地使用Spring Cloud Gateway，来源于Spring Cloud官方案例，地址:
```$xslt
https://spring.io/guides/gs/gateway 
```

- 简介

Spring Cloud Gateway是Spring Cloud官方推出的第二代网关框架，取代Zuul网关。网关作为流量的，在微服务系统中有着非常作用，网关常见的功能有路由转发、权限校验、限流控制等作用。本文首先用官方的案例带领大家来体验下Spring Cloud的一些简单的功能，在后续文章我会使用详细的案例和源码解析来详细讲解Spring Cloud Gateway.

- 创建工程

本案例的的源码下载于官方案例，也可以在我的Github上下载。工程使用的Spring Boot版本为2.0.5.RELEASE，Spring Cloud版本为Finchley.SR1。

新建一个工程，取名为sc-f-gateway-first-sight在工程的pom文件引用工程所需的依赖，包括spring boot和spring cloud，以及gateway的起步依赖spring-cloud-starter-gateway，代码如下：

```
        <!--网关geteway-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-gateway</artifactId>
        </dependency>

        <!--熔断器hystrix-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
```
* 注：详细的pom文件依赖，可以见源码。*

- 创建一个简单的路由

在spring cloud gateway中使用RouteLocator的Bean进行路由转发，将请求进行处理，最后转发到目标的下游服务。在本案例中，会将请求转发到http://httpbin.org:80这个地址上。代码如下：
```
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder){
        String httpUrl = "http://httpbin.org:80";
        return builder.routes()
                .route(p -> p
                        .path("/get") //请求路径
                        .filters(f -> f.addRequestHeader("Hello","World")) //添加request 头部参数
                        .uri(httpUrl)) //转发请求到指定地址
                .build();
    }
```
在上面的myRoutes方法中，使用了一个RouteLocatorBuilder的bean去创建路由，除了创建路由RouteLocatorBuilder可以让你添加各种predicates和filters，predicates断言的意思，顾名思义就是根据具体的请求的规则，由具体的route去处理，filters是各种过滤器，用来对请求做各种判断和修改。

上面创建的route可以让请求“/get”请求都转发到“http://httpbin.org/get”。在route配置上，我们添加了一个filter，该filter会将请求添加一个header,key为hello，value为world。

启动springboot项目，在浏览器上http://localhost:8080/get，浏览器显示如下:
```$xslt
{
  "args": {}, 
  "headers": {
    "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8", 
    "Accept-Encoding": "gzip, deflate, br", 
    "Accept-Language": "zh-CN,zh;q=0.9", 
    "Connection": "close", 
    "Forwarded": "proto=http;host=\"localhost:8080\";for=\"0:0:0:0:0:0:0:1:64306\"", 
    "Hello": "World", 
    "Host": "httpbin.org", 
    "Upgrade-Insecure-Requests": "1", 
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3554.0 Safari/537.36", 
    "X-Forwarded-Host": "localhost:8080"
  }, 
  "origin": "0:0:0:0:0:0:0:1, 210.13.127.166", 
  "url": "http://localhost:8080/get"
}
```
可见当我们向gateway工程请求“/get”,gateway会将工程的请求转发到“http://httpbin.org/get”，并且在转发之前，加上一个filter，该filter会将请求添加一个header,key为hello，value为world。

注意HTTPBin展示了请求的header hello和值world。

- 使用Hystrix

在spring cloud gateway中可以使用Hystrix。Hystrix是 spring cloud中一个服务熔断降级的组件，在微服务系统有着十分重要的作用。 Hystrix是 spring cloud gateway中是以filter的形式使用的，代码如下：

```$xslt
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder){
        String httpUrl = "http://httpbin.org:80";
        return builder.routes()
                .route(p -> p
                        .path("/get") //请求路径
                        .filters(f -> f.addRequestHeader("Hello","World")) //添加request 头部参数
                        .uri(httpUrl)) //转发请求到指定地址
                //配置hystrix熔断机制
                .route(p -> p
                        .host("*.hystrix.com") //当请求的host有“*.hystrix.com”，都会进入该router
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("mycmd")
                                        .setFallbackUri("forward:/fallback")))
                        .uri(httpUrl))

                .build();
    }
```
在上面的代码中，我们使用了另外一个router，该router使用host去断言请求是否进入该路由，当请求的host有“*.hystrix.com”，都会进入该router，该router中有一个hystrix的filter,该filter可以配置名称、和指向性fallback的逻辑的地址，比如本案例中重定向到了“/fallback”。

现在写的一个“/fallback”的l逻辑：

```$xslt
    @RequestMapping("/fallback")
    public Mono<String> fallback(){
        return Mono.just("fallback");
    }
```

Mono是一个Reactive stream，对外输出一个“fallback”字符串。

- 使用curl执行以下命令：
```$xslt
$ curl --dump-header - --header 'Host: www.hystrix.com' http://localhost:8080/delay/3
```
返回的响应为：
```$xslt
fallback
```

可见，带hostwww.hystrix.com的请求执行了hystrix的fallback的逻辑。

- ###总结

本文通过官方的一个简单的案例，来讲解了spring cloud gateway的简单用法，在spring cloud gateway中有2个重要的概念predicates和filters，将会在后续文章讲解。敬请期待。

源码下载
```$xslt
https://github.com/forezp/SpringCloudLearning/tree/master/sc-f-gateway-first-sight
```
