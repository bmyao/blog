package com.oneself.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.oneself.blog.**.dao")
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = "com.oneself.blog.common.config")
public class BlogCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogCoreApplication.class, args);
    }

}
