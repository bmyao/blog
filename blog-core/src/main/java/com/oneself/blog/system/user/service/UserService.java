package com.oneself.blog.system.user.service;

import com.oneself.blog.system.user.entity.qo.UserRegisterQO;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/2 15:38
 * @Version 1.0
 */
public interface UserService {

    /**
     * @Author liangjiayao
     * @Description 注册用户
     * @Date 2019/8/2 15:40
     * @Param [userRegisterQO]
     * @return void
     **/
    void registerUser(UserRegisterQO userRegisterQO);
}
