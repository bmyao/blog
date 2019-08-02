package com.oneself.blog.system.user.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/29 17:38
 * @Version 1.0
 */
@Data
public class LoginUserDTO implements Serializable {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String loginPasswork;

    /**
     * 状态
     */
    private String status;

    public Integer getId() {
        return userId;
    }
}
