package com.oneself.blog.common.shiro;

import com.oneself.blog.common.config.ShiroSessionManager;
import com.oneself.blog.common.properties.BlogConfigProperties;
import com.oneself.blog.common.properties.RedisProperties;
import com.oneself.blog.common.properties.BlogSpringProperties;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/29 10:09
 * @Version 1.0
 */
@Configuration
public class ShiroConfig {

    @Resource
    private BlogConfigProperties blogConfigProperties;

    @Resource
    private BlogSpringProperties blogSpringProperties;

    /**
     * @Author liangjiayao
     * @Description shiro拦截配置
     * @Date 2019/7/31 17:56
     * @Param [securityManager]
     * @return org.apache.shiro.spring.web.ShiroFilterFactoryBean
     * **
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     * Web应用中,Shiro可控制的Web请求必须经过Shiro主过滤器的拦截
     **/
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        //创建一个shiro工厂拦截
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        //获取filters
//        Map<String, Filter> filters = shiroFilter.getFilters();
//        filters.put("user", new CustomUserFilter());

        // 设置 securityManager
        shiroFilter.setSecurityManager(securityManager);
        // 登录的 url
        shiroFilter.setLoginUrl(blogConfigProperties.getShiro().getLoginUrl());
        // 登录成功后跳转的 url
        shiroFilter.setSuccessUrl(blogConfigProperties.getShiro().getSuccessUrl());
        // 未授权 url
        shiroFilter.setUnauthorizedUrl(blogConfigProperties.getShiro().getUnauthorizedUrl());

        Map<String, String> filterMap = new LinkedHashMap<>();
        // 设置免认证 url
        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(blogConfigProperties.getShiro().getAnonUrl(), ",");
        for (String url : anonUrls) {
            filterMap.put(url, "anon");
        }
        // 除上以外所有 url都必须认证通过才可以访问，未通过认证自动访问 LoginUrl
        filterMap.put("/**", "user");
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;
    }

    /**
     * @Author liangjiayao
     * @Description 配置核心安全事务管理器
     * @Date 2019/7/31 17:56
     * @Param []
     * @return org.apache.shiro.mgt.SecurityManager
     **/
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 配置 SecurityManager，并注入 shiroRealm
        securityManager.setRealm(shiroRealm());
        // 配置 rememberMeCookie
        securityManager.setRememberMeManager(rememberMeManager());
        // 配置 缓存管理类 cacheManager
        securityManager.setCacheManager(cacheManager());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    /**
     * @Author liangjiayao
     * @Description 自定义realm，实现登录校验和权限
     * @Date 2019/7/31 14:51
     * @Param []
     * @return com.oneself.blog.common.shiro.ShiroRealm
     **/
    @Bean
    public ShiroRealm shiroRealm() {
        // 配置 Realm，需自己实现
        return new ShiroRealm();
    }


    /**
     * @Author liangjiayao
     * @Description cookie管理对象
     * @Date 2019/7/31 14:54
     * @Param []
     * @return org.apache.shiro.web.mgt.CookieRememberMeManager
     **/
    private CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        // rememberMe cookie 加密的密钥
        cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }
    
    /**
     * @Author liangjiayao
     * @Description rememberMe cookie 效果是重开浏览器后无需重新登录
     * @Date 2019/7/31 14:52
     * @Param []
     * @return org.apache.shiro.web.servlet.SimpleCookie
     **/
    private SimpleCookie rememberMeCookie() {
        // 设置 cookie 名称，对应 login.html 页面的 <input type="checkbox" name="rememberMe"/>
        SimpleCookie cookie = new SimpleCookie("platform_rememberMe");
        // 设置 cookie 的过期时间，单位为秒，这里为一天
        cookie.setMaxAge(blogConfigProperties.getShiro().getCookieTimeout());
        cookie.setHttpOnly(false);
        return cookie;
    }

    /**
     * @Author liangjiayao
     * @Description shiro缓存管理器
     * @Date 2019/7/31 15:02
     * @Param []
     * @return RedisCacheManager
     **/
    @Bean
    public RedisCacheManager cacheManager(){
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        //redis中针对不同用户缓存
        redisCacheManager.setPrincipalIdFieldName("username");
        //用户权限信息缓存时间
        redisCacheManager.setExpire(200000);
        return redisCacheManager;
    }

    /**
     * @Author liangjiayao
     * @Description redis缓存
     * @Date 2019/7/31 15:11
     * @Param []
     * @return org.crazycake.shiro.RedisManager
     **/
    @Bean
    public RedisManager redisManager(){
        RedisProperties redis = blogSpringProperties.getRedis();
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(redis.getHost());
        redisManager.setPort(redis.getPort());
        if (StringUtils.isNotBlank(redis.getPassword())) {
            redisManager.setPassword(redis.getPassword());
        }
        redisManager.setTimeout(redis.getTimeout());
        return redisManager;
    }

    /**
     * @Author liangjiayao
     * @Description session 管理对象
     * @Date 2019/8/1 10:44
     * @Param []
     * @return org.apache.shiro.session.mgt.SessionManager
     **/
    @Bean
    public SessionManager sessionManager() {
        ShiroSessionManager sessionManager = new ShiroSessionManager();
        sessionManager.setSessionIdCookie(getSessionIdCookie());
        sessionManager.setSessionDAO(redisSessionDAO());
        // 设置session超时
        sessionManager.setGlobalSessionTimeout(blogConfigProperties.getShiro().getSessionTimeout());
        return sessionManager;
    }

    /**
     * @Author liangjiayao
     * @Description 给shiro的sessionId默认的JSSESSIONID名字改掉
     * @Date 2019/8/1 10:44
     * @Param []
     * @return org.apache.shiro.web.servlet.SimpleCookie
     **/
    @Bean(name="sessionIdCookie")
    public SimpleCookie getSessionIdCookie(){
        SimpleCookie simpleCookie = new SimpleCookie(blogConfigProperties.getShiro().getSessionid());
        return simpleCookie;
    }

    /**
     * @Author liangjiayao
     * @Description SessionDAO的作用是为Session提供CRUD并进行持久化的一个shiro组件
     * @Date 2019/8/1 10:54
     * @Param []
     * @return org.apache.shiro.session.mgt.eis.SessionDAO
     * MemorySessionDAO 直接在内存中进行会话维护
     * EnterpriseCacheSessionDAO  提供了缓存功能的会话维护，默认情况下使用MapCache实现，内部使用ConcurrentHashMap保存缓存的会话。
     **/
    @Bean
    public SessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        //session在redis中的保存时间,最好大于session会话超时时间
        //redisSessionDAO.setExpire(12000);
        return redisSessionDAO;
    }

    /**
     * @Author liangjiayao
     * @Description 开启shiro 注解模式,可以在controller中的方法前加上注解, 如 @RequiresPermissions("userInfo:add")
     * @Date 2019/8/1 10:54
     * @Param [securityManager]
     * @return org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor
     **/
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    
//    /**
//     * @Author liangjiayao
//     * @Description 并发登录控制-->控制登录账号同时在线数量
//     * @Date 2019/7/31 11:22
//     * @Param []
//     * @return KickoutSessionControlFilter
//     **/
//    @Bean
//    public KickoutSessionControlFilter kickoutSessionControlFilter(){
//        KickoutSessionControlFilter kickoutSessionControlFilter = new KickoutSessionControlFilter();
//        //用于根据会话ID，获取会话进行踢出操作的；
//        kickoutSessionControlFilter.setSessionManager(sessionManager());
//        //使用cacheManager获取相应的cache来缓存用户登录的会话；用于保存用户—会话之间的关系的；
//        kickoutSessionControlFilter.setCacheManager(cacheManager());
//        //是否踢出后来登录的，默认是false；即后者登录的用户踢出前者登录的用户；
//        kickoutSessionControlFilter.setKickoutAfter(false);
//        //同一个用户最大的会话数，默认1；比如2的意思是同一个用户允许最多同时两个人登录；
//        kickoutSessionControlFilter.setMaxSession(1);
//        //被踢出后重定向到的地址；
//        kickoutSessionControlFilter.setKickoutUrl("/login?kickout=1");
//        return kickoutSessionControlFilter;
//    }

}
