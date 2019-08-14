package com.oneself.blog.system.menu.entity.co;

import lombok.Data;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/10 11:11
 * @Version 1.0
 */
@Data
public class MenuAddCO {

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
}
