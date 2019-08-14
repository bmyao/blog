package com.oneself.blog.system.menu.entity.vo;

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
public class RoleMenuTreeVO {

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
     * 菜单排序
     */
    private Integer menuSort;

    /**
     * 菜单类别
     */
    private String menuType;

    /**
     * 岗位是否已有菜单权限
     **/
    private boolean checkbox = false;

    /**
     * 是否有子菜单或者按钮
     **/
    private boolean childList = false;

    /**
     * 子菜单或者按钮
     **/
    private List<RoleMenuTreeVO> list = new ArrayList<>();
}
