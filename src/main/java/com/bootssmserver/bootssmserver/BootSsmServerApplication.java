package com.bootssmserver.bootssmserver;

import com.bootssmserver.bootssmserver.configution.SpringConfigution;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//SpringBoot入口函数
@EnableTransactionManagement //默认启动时 开启事务管理器
@SpringBootApplication
public class BootSsmServerApplication  {

    public static void main(String[] args) {
        SpringApplication.run(BootSsmServerApplication.class, args);
    }

}
