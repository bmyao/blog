package com.oneself.blog.core;

import com.oneself.blog.common.properties.BlogConfigProperties;
import com.oneself.blog.common.properties.BlogSpringProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableConfigurationProperties({BlogConfigProperties.class, BlogSpringProperties.class})
public class BlogCoreApplicationTests {

    @Test
    public void contextLoads() {
    }

}
