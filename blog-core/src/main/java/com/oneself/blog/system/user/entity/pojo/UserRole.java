package com.oneself.blog.system.user.entity.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class UserRole {

    /**
     * 用户角色表ID
     */
    private Integer userRoleId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 创建时间
     */
    private Date createTime;

}