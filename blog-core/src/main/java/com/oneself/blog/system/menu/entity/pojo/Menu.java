package com.oneself.blog.system.menu.entity.pojo;

import com.oneself.blog.common.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

@Data
public class Menu {

    /**
     * 菜单code
     */
    private String menuCode;

    /**
     * 父菜单code
     */
    private String parentCode;

    /**
     * 菜单名字
     */
    private String menuName;

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
    private StatusEnum status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private Integer updateUser;

}