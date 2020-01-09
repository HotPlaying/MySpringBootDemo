package com.training.mysites;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 静态资源放在resources/static目录下
 * thymleaf模板放在resources/templates目录下
 * SpringBoot默认首页是/static目录下的index.html或index控制器
 */

@SpringBootApplication
public class MysitesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysitesApplication.class, args);
    }

}
