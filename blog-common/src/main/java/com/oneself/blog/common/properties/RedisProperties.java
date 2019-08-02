package com.oneself.blog.common.properties;

import lombok.Data;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/31 17:35
 * @Version 1.0
 */
@Data
public class RedisProperties {

    /**
     *  redis的host
     **/
    private String host;

    /**
     *  redis的端口
     **/
    private int port;

    /**
     *  redis的密码
     **/
    private String password;

    /**
     *  连接超时时间（毫秒）
     **/
    private int timeout;

    /**
     *  Redis数据库索引（默认为0）
     **/
    private int database;
}
