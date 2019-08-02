package com.oneself.blog.system.role.entity.vo;

import com.oneself.blog.common.enums.RoleTypeEnum;
import com.oneself.blog.common.enums.StatusEnum;
import com.oneself.blog.common.utils.EnumUtils;
import lombok.Data;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/25 18:02
 * @Version 1.0
 */
@Data
public class RoleListVO {

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

    /**
     * 角色类型（ 0:超级管理员  1:普通管理员  2:普通用户 ）
     */
    private String roleTypeName;

    /**
     * 角色状态（ 0:禁止  1:启用 ）
     */
    private String roleStatus;

    /**
     * 角色状态（ 0:禁止  1:启用 ）
     */
    private String roleStatusName;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 修改时间
     */
    private String updateTime;

    public String getRoleTypeName() {
        return EnumUtils.getByValue(RoleTypeEnum.class,roleType).getName();
    }

    public String getRoleStatusName() {
        return EnumUtils.getByValue(StatusEnum.class,roleStatus).getName();
    }
}
