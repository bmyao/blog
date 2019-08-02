package com.oneself.blog.system.role.entity.dto;

import lombok.Data;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/29 17:03
 * @Version 1.0
 */
@Data
public class LoginRoleDTO {

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 角色code
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色类型（ 0:超级管理员  1:普通管理员  2:普通用户 ）
     */
    private String roleType;
}
