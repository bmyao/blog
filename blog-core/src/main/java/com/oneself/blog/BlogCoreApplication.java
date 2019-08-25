package com.oneself.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.oneself.blog.**.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class BlogCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogCoreApplication.class, args);
    }

}
