package com.oneself.blog.common.properties;

import lombok.Data;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/30 10:51
 * @Version 1.0
 */
@Data
public class BlogConfigProperties {

    /**
     * 是否在控制台打印 sql语句
     **/
    private String showsql;

    /**
     * 时间类型参数在前端页面的展示格式，默认格式为 yyyy-MM-dd HH:mm:ss
     **/
    private String timeFormat;

    /**
     * 是否开启 AOP 日志，默认开启
     **/
    private boolean openAopLog;

    /**
     * shiro
     **/
    private ShiroProperties shiro = new ShiroProperties();

}
