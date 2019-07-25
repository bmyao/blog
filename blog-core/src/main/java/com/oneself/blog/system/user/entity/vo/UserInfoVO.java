package com.oneself.blog.system.user.entity.vo;

import com.oneself.blog.common.enums.SexEnum;
import com.oneself.blog.common.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/25 15:15
 * @Version 1.0
 */
@Data
public class UserInfoVO {

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
     * 用户名字
     */
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
    private String userSex;

    /**
     * 用户个性签名
     */
    private String userSignature;

}
