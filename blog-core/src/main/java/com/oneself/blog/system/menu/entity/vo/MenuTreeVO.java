package com.oneself.blog.system.menu.entity.vo;

import com.oneself.blog.common.enums.StatusEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/13 11:57
 * @Version 1.0
 */
@Data
public class MenuTreeVO {

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
     * 是否有子菜单或者按钮
     **/
    private boolean childList = false;

    /**
     * 子菜单或者按钮
     **/
    private List<MenuTreeVO> list = new ArrayList<>();
}
