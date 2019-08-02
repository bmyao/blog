package com.oneself.blog.system.menu.entity.dto;

import com.oneself.blog.common.enums.StatusEnum;
import com.oneself.blog.common.utils.EnumUtils;
import lombok.Data;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/26 16:38
 * @Version 1.0
 */
@Data
public class MenuListDTO {

    /**
     * 菜单code
     */
    private String menuCode;

    /**
     * 菜单名字
     */
    private String menuName;

    /**
     * 父菜单code
     */
    private String parentCode;

    /**
     * 父菜单name
     */
    private String parentName;

    /**
     * 按钮标识
     */
    private String buttonCode;

    /**
     * 菜单URL
     */
    private String menuUrl;

    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 菜单排序
     */
    private Integer menuSort;

    /**
     * 菜单类别
     */
    private String menuType;

    /**
     * shiro权限标识
     */
    private String perms;

    /**
     * 菜单状态（ 0:禁止  1:启用 ）
     */
    private String status;

    /**
     * 菜单状态（ 0:禁止  1:启用 ）
     */
    private String statusName;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 创建人
     */
    private String createUserName;

    /**
     * 修改时间
     */
    private String updateTime;

    /**
     * 修改人
     */
    private String updateUserName;

    public String getStatusName() {
        return EnumUtils.getByValue(StatusEnum.class,status).getName();
    }
}
