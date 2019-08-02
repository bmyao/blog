package com.oneself.blog.system.role.entity.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class RoleMenu {

    /**
     * 角色菜单表ID
     */
    private Integer roleMenuId;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 菜单code
     */
    private String menuCode;

    /**
     * 创建人
     */
    private Integer cteateUser;

    /**
     * 创建时间
     */
    private Date createTime;
}