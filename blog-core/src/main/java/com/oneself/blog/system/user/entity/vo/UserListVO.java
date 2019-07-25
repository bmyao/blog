package com.oneself.blog.system.user.entity.vo;

import lombok.Data;


/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/25 15:15
 * @Version 1.0
 */
@Data
public class UserListVO {

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
     * 用户性别（ 0:男  1:女  2:保密 ）
     */
    private String userSex;

    /**
     * 用户状态（ 0:禁止  1:启用 ）
     */
    private String status;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;

    /**
     * 修改人
     */
    private String updateUserName;

}
