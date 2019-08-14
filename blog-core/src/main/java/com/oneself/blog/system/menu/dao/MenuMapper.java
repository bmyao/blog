package com.oneself.blog.system.menu.dao;

import com.oneself.blog.system.menu.entity.dto.MenuListDTO;
import com.oneself.blog.system.menu.entity.dto.RoleMenuDTO;
import com.oneself.blog.system.menu.entity.pojo.Menu;
import com.oneself.blog.system.menu.entity.co.MenuListCO;
import com.oneself.blog.system.menu.entity.dto.LoginMenuDTO;
import com.oneself.blog.system.menu.entity.vo.MenuListVO;
import com.oneself.blog.system.menu.entity.vo.MenuTreeVO;
import com.oneself.blog.system.menu.entity.vo.RoleMenuTreeVO;

import java.util.List;
import java.util.Set;

public interface MenuMapper {

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/7/26 17:04
     * @Param [record]
     * @return int
     **/
    void insert(Menu menu);
    
    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/7/26 17:04
     * @Param [menuCode]
     * @return int
     **/
    void deleteByCode(String menuCode);

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/7/26 17:05
     * @Param [record]
     * @return void
     **/
    void updateByCode(Menu menu);

    /**
     * @Author liangjiayao
     * @Description 修改菜单状态
     * @Date 2019/7/26 17:05
     * @Param [menu]
     * @return void
     **/
    void updateStatus(Menu menu);

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/7/26 17:15
     * @Param [menuListCO]
     * @return java.util.List<com.oneself.blog.system.menu.entity.dto.MenuListDTO>
     **/
    List<MenuListVO> selectListByCondition(MenuListCO menuListCO);

    /**
     * @Author liangjiayao
     * @Description 查询所有启用状态的菜单
     * @Date 2019/8/14 9:49
     * @Param []
     * @return java.util.List<com.oneself.blog.system.menu.entity.vo.RoleMenuTreeVO>
     **/
    List<RoleMenuTreeVO> selectAllMenuByEnable();

    /**
     * @Author liangjiayao
     * @Description 用户id查询菜单
     * @Date 2019/8/1 17:21
     * @Param [userId]
     * @return java.util.List<com.oneself.blog.system.menu.entity.dto.LoginMenuDTO>
     **/
    List<MenuTreeVO> selectMenusByUserId(Integer userId);

    /**
     * @Author liangjiayao
     * @Description userid查询菜单perms
     * @Date 2019/8/14 14:37
     * @Param []
     * @return java.util.Set<java.lang.String>
     **/
    Set<String> selectMenuPermsByUserId(Integer userId);
}
