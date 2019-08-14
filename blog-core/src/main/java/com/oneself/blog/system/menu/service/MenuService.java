package com.oneself.blog.system.menu.service;

import com.oneself.blog.system.menu.entity.co.MenuAddCO;
import com.oneself.blog.system.menu.entity.co.MenuEditCO;
import com.oneself.blog.system.menu.entity.co.MenuListCO;
import com.oneself.blog.system.menu.entity.dto.LoginMenuDTO;
import com.oneself.blog.system.menu.entity.dto.MenuListDTO;
import com.oneself.blog.system.menu.entity.dto.RoleMenuDTO;
import com.oneself.blog.system.menu.entity.vo.MenuListVO;
import com.oneself.blog.system.menu.entity.vo.MenuTreeVO;
import com.oneself.blog.system.menu.entity.vo.RoleMenuTreeVO;

import java.util.List;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/10 11:02
 * @Version 1.0
 */
public interface MenuService {

    /**
     * @Author liangjiayao
     * @Description 新增菜单
     * @Date 2019/8/10 11:14
     * @Param [menuAddCO]
     * @return void
     **/
    void addMenu(MenuAddCO menuAddCO);

    /**
     * @Author liangjiayao
     * @Description 删除菜单
     * @Date 2019/8/10 11:46
     * @Param [menuCode]
     * @return void
     **/
    void removeMenu(String menuCode);

    /**
     * @Author liangjiayao
     * @Description 修改菜单
     * @Date 2019/8/10 11:34
     * @Param [menuEditCO]
     * @return void
     **/
    void editMenu(MenuEditCO menuEditCO);

    /**
     * @Author liangjiayao
     * @Description 启动菜单状态
     * @Date 2019/8/14 10:04
     * @Param [menuCode]
     * @return void
     **/
    void editMenuEnableStatus(String menuCode);

    /**
     * @Author liangjiayao
     * @Description 禁止菜单状态
     * @Date 2019/8/14 10:04
     * @Param [menuCode]
     * @return void
     **/
    void editMenuDisableStatus(String menuCode);

    /**
     * @Author liangjiayao
     * @Description 条件查询列表
     * @Date 2019/8/10 11:54
     * @Param [menuListCO]
     * @return java.util.List<com.oneself.blog.system.menu.entity.vo.MenuListVO>
     **/
    List<MenuListVO> findListByCondition(MenuListCO menuListCO);

    /**
     * @Author liangjiayao
     * @Description 根据用户id查询菜单
     * @Date 2019/8/10 11:58
     * @Param [userId]
     * @return java.util.List<com.oneself.blog.system.menu.entity.vo.MenuTreeVO>
     **/
    List<MenuTreeVO> findMenusByUserId(Integer userId);

    /**
     * @Author liangjiayao
     * @Description 根据角色查询菜单
     * @Date 2019/8/13 16:22
     * @Param [roleId]
     * @return java.util.List<com.oneself.blog.system.menu.entity.vo.RoleMenuTreeVO>
     **/
    List<RoleMenuTreeVO> findMenuByRoleId(Integer roleId);




}
