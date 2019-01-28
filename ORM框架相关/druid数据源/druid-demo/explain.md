SpringBoot整合druid数据源及添加Druid监控页面

不是不会，只是没见过，代码只是一种工具，首先要会用，应用中使用druid连接池，并添加监控

1.首先引入druid坐标
```$xslt
<dependency>
    <groupId>com.alibaba</groupId>
     <artifactId>druid</artifactId>
     <version>1.0.11</version>
</dependency>
```

2.添加druid配置参数
参考:

数据库连接池优化配置(druid,dbcp,c3p0)
```$xslt
参数	                            默认值	                解释
initialSize	                    3	                    初始化配置
minIdle                             3                       最小连接数
maxActive	                    15	                    最大连接数
maxWait	                        5000	                获取连接超时时间（单位：ms）
timeBetweenEvictionRunsMillis	90000	                连接有效性检测时间(单位:ms)
testOnBorrow	                false	                获取连接检测
testOnReturn	                false	                归还连接检测
minEvictableIdleTimeMillis	1800000	                最大空闲时间(单位ms)
testWhileIdle	                true	                在获取连接后，确定是否要进行连接空间时间的检查
```

配置说明：
1：minEvictableIdleTimeMillis(最大空闲时间)：默认为30分钟，配置里面不进行设置。

2：testOnBorrow ,testOnReturn 默认为关闭，可以设置为不配置。

3：testWhileIdle(在获取连接后，确定是否要进行连接空闲时间的检查)。默认为true。配置里面不再进行设置。

流程说明：
1：在第一次调用connection的时候，才会进行 initialSize的初始化。

2：心跳检测时间线程，会休眠timeBetweenEvictionRunsMillis时间，然后只对(没有borrow的线程 减去 minIdle)的线程进行检查，如果空闲时间大于minEvictableIdleTimeMillis则进行close。

3：testWhileIdle必须设置为true，在获取到连接后，先检查testOnBorrow，然后再判定testwhileIdle，如果连接空闲时间大于timeBetweenEvictionRunsMillis，则会进行心跳检测。

4：不需要配置validationQuery，如果不配置的情况下会走ping命令，性能更高。

5：连接保存在数组里面，获取连接的时候，获取数组的最后一位。在imeBetweenEvictionRunsMillis时是从前往后进行检查连接的有效性。

在applicatioin.properties中添加配置

```yaml
druid.url=jdbc:postgresql://139.1X8.1.1X8:1XX0/account
druid.driver-class=org.postgresql.Driver
druid.username=root
druid.password=123
druid.initial-size=1
druid.min-idle=1
druid.max-active=20
druid.test-on-borrow=true
druid.timeBetweenEvictionRunsMillis=9000
```
3.定义配置类，启动读取druid开头的参数
driver-class有和driverClass是不一样的，所以要引入，参数容错坐标
```mxml
        <!--配置命名容错处理-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
```
```java
@ConfigurationProperties(prefix = "druid")
public class DruidProperties {
    private String url;
    private String username;
    private String password;
    private String driverClass;
    private int maxActive;//最大连接数
    private int minIdle;//最小连接数
    private int initialSize;//初始化数量和
    private boolean testOnBorrow;
    private Long timeBetweenEvictionRunsMillis;//心跳
}
4.注入
@Configuration
@EnableConfigurationProperties(DruidProperties.class)
@ConditionalOnClass(DruidDataSource.class)
@ConditionalOnProperty(prefix = "druid", name = "url")
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DruidAutoConfiguration {

    @Autowired
    private DruidProperties properties;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        if (properties.getInitialSize() > 0) {
            dataSource.setInitialSize(properties.getInitialSize());
        }
        if (properties.getMinIdle() > 0) {
            dataSource.setMinIdle(properties.getMinIdle());
        }
        if (properties.getMaxActive() > 0) {
            dataSource.setMaxActive(properties.getMaxActive());
        }
        dataSource.setTestOnBorrow(properties.isTestOnBorrow());
        try {
            dataSource.init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }
}
5.添加拦截器，拦截器druid性能监控
/**
 * @Package: pterosaur.account.config.druid
 * @Description: 监控数据库性能
 * @author: liuxin
 * @date: 17/4/21 上午11:23
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/druid/*",
        initParams={
                @WebInitParam(name="allow",value="192.168.16.110,127.0.0.1"),// IP白名单 (没有配置或者为空，则允许所有访问)
                @WebInitParam(name="deny",value="192.168.16.111"),// IP黑名单 (存在共同时，deny优先于allow)
                @WebInitParam(name="loginUsername",value="test"),// 用户名
                @WebInitParam(name="loginPassword",value="test"),// 密码
                @WebInitParam(name="resetEnable",value="false")// 禁用HTML页面上的“Reset All”功能
        })
public class DruidStatViewServlet extends StatViewServlet{
}


/**
 * @Package: pterosaur.account.config.filter
 * @Description: 拦截druid监控请求
 * @author: liuxin
 * @date: 17/4/21 上午11:24
 */
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
        })
public class DruidStatFilter extends WebStatFilter{
}

6.最终要一步，启动扫描Servlet
@SpringBootApplication
@MapperScan(basePackages = "pterosaur.account.mapper")
@EnableCaching
@ServletComponentScan  //这个
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
```




###访问
http://localhost:8080/druid/api.html