package com.training.mysites;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 静态资源放在resources/static目录下
 * thymleaf模板放在resources/templates目录下
 * SpringBoot默认首页是/static目录下的index.html或index控制器
 * jar独立运行
 * war需要部署到web服务器，war包：
 * 1.修改配置文件pom.xml
 * 2.SpringBootServletInitializer
 */

@SpringBootApplication
public class MysitesApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(MysitesApplication.class, args);
    }

}
