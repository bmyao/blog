package com.oneself.blog.system.user.entity.co;

import com.oneself.blog.common.enums.SexEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/2 15:32
 * @Version 1.0
 */
@Data
public class UserRegisterCO {

    /**
     * 登录账号
     */
    @NotBlank(message = "账号不能为空")
    private String loginName;

    /**
     * 登录密码
     */
    @NotBlank(message = "密码不能为空")
    private String loginPassword;

    /**
     * 用户名字
     */
    @NotBlank(message = "用户名字不能为空")
    private String userName;

    /**
     * 用户手机
     */
    private String userPhone;

    /**
     * 用户QQ
     */
    private String userQq;

    /**
     * 用户头像
     */
    private String userHeadUrl;

    /**
     * 用户性别（ 0:男  1:女  2:保密 ）
     */
    @NotNull
    private SexEnum userSex;

    /**
     * 用户个性签名
     */
    private String userSignature;
}
