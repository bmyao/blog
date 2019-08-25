package com.oneself.blog.common.properties;

import lombok.Data;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/31 15:11
 * @Version 1.0
 */
@Data
public class BlogSpringProperties {

    /**
     *  rendis
     **/
    private RedisProperties redis = new RedisProperties();

}
