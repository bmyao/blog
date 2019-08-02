package com.oneself.blog.system.user.entity.pojo;

import com.oneself.blog.common.enums.SexEnum;
import com.oneself.blog.common.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

@Data
public class User {

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
    private String loginPassword;

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
    private SexEnum userSex;

    /**
     * 用户个性签名
     */
    private String userSignature;

    /**
     * 用户状态（ 0:禁止  1:启用 ）
     */
    private StatusEnum status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private Integer updateUser;

}