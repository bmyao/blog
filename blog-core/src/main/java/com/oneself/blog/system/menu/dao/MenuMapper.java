package com.oneself.blog.system.menu.dao;

import com.oneself.blog.system.menu.entity.dto.MenuListDTO;
import com.oneself.blog.system.menu.entity.pojo.Menu;
import com.oneself.blog.system.menu.entity.qo.MenuListQO;
import com.oneself.blog.system.menu.entity.dto.LoginMenuDTO;

import java.util.List;

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
     * @Description
     * @Date 2019/7/26 17:05
     * @Param [menu]
     * @return void
     **/
    void updateStatus(Menu menu);

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/7/26 17:15
     * @Param [menuListQO]
     * @return java.util.List<com.oneself.blog.system.menu.entity.dto.MenuListDTO>
     **/
    List<MenuListDTO> findListByCondition(MenuListQO menuListQO);

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/8/1 17:21
     * @Param [userId]
     * @return java.util.List<com.oneself.blog.system.menu.entity.dto.LoginMenuDTO>
     **/
    List<LoginMenuDTO> findMenusByUserId(Integer userId);
}