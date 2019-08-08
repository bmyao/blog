package com.oneself.blog.system.role.entity.co;

import com.oneself.blog.common.enums.RoleTypeEnum;
import com.oneself.blog.common.enums.StatusEnum;
import lombok.Data;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/25 18:02
 * @Version 1.0
 */
@Data
public class RoleListCO {

    /**
     * 角色code或者角色名称
     */
    private String item;

    /**
     * 角色类型（ 0:超级管理员  1:普通管理员  2:普通用户 ）
     */
    private RoleTypeEnum roleType;

    /**
     * 角色状态（ 0:禁止  1:启用 ）
     */
    private StatusEnum roleStatus;
}
