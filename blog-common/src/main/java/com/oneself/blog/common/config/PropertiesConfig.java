package com.oneself.blog.common.config;

import com.oneself.blog.common.properties.BlogConfigProperties;
import com.oneself.blog.common.properties.SpringProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/31 15:32
 * @Version 1.0
 */
@Configuration
public class PropertiesConfig {

    @Bean
    @ConfigurationProperties(prefix = "blog-config")
    public BlogConfigProperties blogConfigProperties(){
        return new BlogConfigProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring")
    public SpringProperties springProperties(){
        return new SpringProperties();
    }
}
