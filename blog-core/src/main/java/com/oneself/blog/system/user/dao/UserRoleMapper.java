package com.oneself.blog.system.user.dao;

import com.oneself.blog.system.user.entity.pojo.UserRole;
import java.util.List;

public interface UserRoleMapper {

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/7/25 17:13
     * @Param [record]
     * @return void
     **/
    void insert(UserRole record);

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/7/25 17:13
     * @Param [userId]
     * @return void
     **/
    void deleteById(Integer userId);

}