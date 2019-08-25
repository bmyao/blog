package com.oneself.blog.core.generator;

import com.oneself.blog.common.properties.BlogConfigProperties;
import com.oneself.blog.common.properties.RedisProperties;
import com.oneself.blog.common.properties.ShiroProperties;
import com.oneself.blog.common.properties.BlogSpringProperties;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/19 16:13
 * @Version 1.0
 */
public class generator {

    @Resource
    private BlogConfigProperties blogConfigProperties;

    @Resource
    private BlogSpringProperties blogSpringProperties;

    @Test
    public void test(){
        String timeFormat = blogConfigProperties.getTimeFormat();
        ShiroProperties shiro = blogConfigProperties.getShiro();
        RedisProperties redis = blogSpringProperties.getRedis();
        System.out.println(shiro.toString()+"   "+timeFormat+"  "+redis.toString());
    }

    @Test
    public void MBG() throws Exception{
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(new File("./src/main/resources/generator/generator.xml"));
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
