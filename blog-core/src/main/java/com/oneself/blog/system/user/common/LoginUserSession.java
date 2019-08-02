package com.oneself.blog.system.user.common;

import com.oneself.blog.system.user.entity.dto.LoginUserDTO;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Component;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/2 14:34
 * @Version 1.0
 */
@Component
public class LoginUserSession {

    /**
     * 从缓存获取当前用户
     * */
    public LoginUserDTO getCurrentUser() {
        return (LoginUserDTO) SecurityUtils.getSubject().getPrincipal();
    }
}
