package com.oneself.blog.system.role.dao;

import com.oneself.blog.system.role.entity.dto.LoginRoleDTO;
import com.oneself.blog.system.role.entity.pojo.Role;
import com.oneself.blog.system.role.entity.co.RoleListCO;
import com.oneself.blog.system.role.entity.vo.RoleListVO;

import java.util.List;

public interface RoleMapper {

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/7/25 17:58
     * @Param [record]
     * @return void
     **/
    void insert(Role record);

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/7/25 17:58
     * @Param [roleId]
     * @return void
     **/
    void deleteById(Integer roleId);

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/7/25 17:58
     * @Param [record]
     * @return void
     **/
    void updateById(Role record);

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/7/25 18:12
     * @Param [roleListCO]
     * @return java.util.List<com.oneself.blog.system.role.entity.vo.RoleListVO>
     **/
    List<RoleListVO> findListByCondition(RoleListCO roleListCO);

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/7/29 17:08
     * @Param [userId]
     * @return java.util.List<com.oneself.blog.system.role.entity.dto.LoginRoleDTO>
     **/
    List<LoginRoleDTO> findRolesByUserId(Integer userId);


}