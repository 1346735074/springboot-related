package com.demo.ant.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/10 16:36
 * @description:
 */
@Configuration
@MapperScan("com.demo.ant.mapper") //扫描mapper接口
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 mp分页加上
@Slf4j
public class MybatisPlusConfig {

//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        return sessionFactory.getObject();
//    }

//    @Bean("sqlSessionFactory") //yml和bean只能有一个
    public MybatisSqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        log.info(">>>>sqlSessionFactory初始化");
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeEnumsPackage("com.demo.ant.entity.enums");
//        sqlSessionFactoryBean.setMapperLocations(new Resource[]{}); //mybatis sql.xml文件
        MybatisConfiguration configuration = new MybatisConfiguration();
//        configuration.setMapUnderscoreToCamelCase(false); //驼峰下划线转换
        sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean;
    }

    /**
     * 设置sqlsession模板
     * @param sqlSessionFactory
     * @return
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        log.info(">>>>设置sqlsession模板");
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager(DataSource dataSource) {
        log.info(">>>>spring boot事务初始化");
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        log.info(">>>>mp分页插件初始化");
        return new PaginationInterceptor();
    }
}
