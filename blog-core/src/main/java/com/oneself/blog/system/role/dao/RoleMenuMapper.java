package com.oneself.blog.system.role.dao;

import com.oneself.blog.system.role.entity.pojo.RoleMenu;
import java.util.List;

public interface RoleMenuMapper {

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/7/25 17:38
     * @Param [record]
     * @return void
     **/
    void insert(RoleMenu roleMenu);

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/7/25 17:38
     * @Param [roleMenuId]
     * @return void
     **/
    void deleteById(Integer roleId);

    /**
     * @Author liangjiayao
     * @Description 角色id查询菜单
     * @Date 2019/8/14 9:51
     * @Param [roleId]
     * @return java.util.List<java.lang.String>
     **/
    List<String> selectMenuByRoleId(Integer roleId);

}