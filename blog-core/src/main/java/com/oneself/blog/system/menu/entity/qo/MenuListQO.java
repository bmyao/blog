package com.oneself.blog.system.menu.entity.qo;

import com.oneself.blog.common.enums.MenuTypeEnum;
import com.oneself.blog.common.enums.StatusEnum;
import lombok.Data;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/26 17:06
 * @Version 1.0
 */
@Data
public class MenuListQO {

    /**
     * 菜单code或者菜单名称
     */
    private String item;

    /**
     * 角色类型（ 0:超级管理员  1:普通管理员  2:普通用户 ）
     */
    private MenuTypeEnum  menuType;

    /**
     * 菜单状态（ 0:禁止  1:启用 ）
     */
    private StatusEnum status;

}
