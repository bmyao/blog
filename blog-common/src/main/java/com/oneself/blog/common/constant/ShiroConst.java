package com.oneself.blog.common.constant;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/28 9:33
 * @Version 1.0
 */
public class ShiroConst {

    /**
     * session 超时时间，默认1800000毫秒
     */
    public static final Integer SESSION_TIMEOUT = 1800000;

    /**
     * rememberMe cookie有效时长，默认86400秒，即一天
     */
    public static final Integer COOKIE_TIMEOUT = 86400;

    /**
     * 免认证的路径配置，如静态资源，druid监控页面，注册页面，验证码请求等
     */
    public static final String ANON_URL = "/register,/css/**,/js/**,/fonts/**,/img/**,/druid/**,/user/regist,/gifCode,/,/actuator/**,/test/**,/swagger-ui.html,/webjars/**,/v2/**,/swagger-resources/**";

    /**
     * 登录 url
     */
    public static final String LOGIN_URL = "/login";

    /**
     * 登录成功后跳转的 url
     */
    public static final String SUCCESS_URL = "/index";

    /**
     * 登出 url
     */
    public static final String LOGOUT_URL = "/logout";

    /**
     * 未授权跳转 url
     */
    public static final String UNAUTHORIZED_URL = "/403";

    /**
     * sessionId
     */
    public static final String SESSION_ID = "blog_sessionId";

}
