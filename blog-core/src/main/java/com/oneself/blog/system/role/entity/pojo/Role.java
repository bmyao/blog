package com.oneself.blog.system.role.entity.pojo;

import com.oneself.blog.common.enums.RoleTypeEnum;
import com.oneself.blog.common.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

@Data
public class Role {

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
    private RoleTypeEnum roleType;

    /**
     * 角色状态（ 0:禁止  1:启用 ）
     */
    private StatusEnum roleStatus;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Integer updateUser;

    /**
     * 修改时间
     */
    private Date updateTime;

}