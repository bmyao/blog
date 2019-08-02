package com.oneself.blog.common.properties;

import lombok.Data;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/30 11:11
 * @Version 1.0
 */
@Data
public class ShiroProperties {

    /**
     * session 超时时间，默认 1800000毫秒
     **/
    private long sessionTimeout;

    /**
     * rememberMe 有效时长，默认为 86400 秒，即一天
     **/
    private int cookieTimeout;

    /**
     * 免认证的路径配置，如静态资源，druid监控页面，注册页面，验证码请求等
     **/
    private String anonUrl;

    /**
     * 登录 url
     **/
    private String loginUrl;

    /**
     * 登出 url
     **/
    private String logoutUrl;

    /**
     * 登录成功后跳转的 url
     **/
    private String successUrl;

    /**
     * 未授权跳转 url
     **/
    private String unauthorizedUrl;

    /**
     * sessionId
     **/
    private String sessionid;

}
