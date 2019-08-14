package com.oneself.blog.system.user.dao;

import com.oneself.blog.system.user.entity.dto.LoginUserDTO;
import com.oneself.blog.system.user.entity.pojo.User;
import com.oneself.blog.system.user.entity.vo.UserInfoVO;
import com.oneself.blog.system.user.entity.co.UserListCO;
import com.oneself.blog.system.user.entity.vo.UserListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/7/25 16:23
     * @Param [user]
     * @return void
     **/
    void insert(User user);

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/7/25 16:23
     * @Param [userId]
     * @return void
     **/
    void deleteById(Integer userId);

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/7/25 16:23
     * @Param [record]
     * @return void
     **/
    void updateById(User user);

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/7/29 17:53
     * @Param [loginName, loginPassword]
     * @return com.oneself.blog.system.user.entity.dto.LoginUserDTO
     **/
    LoginUserDTO selectUserByLoginNameAndPasswork(@Param("loginName") String loginName , @Param("loginPassword") String loginPassword);

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/7/25 16:24
     * @Param [userListCO]
     * @return java.util.List<com.oneself.blog.system.user.entity.vo.UserListVO>
     **/
    List<UserListVO> selectListByCondition(UserListCO userListCO);

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/7/25 16:27
     * @Param [userId]
     * @return com.oneself.blog.system.user.entity.vo.UserInfoVO
     **/
    UserInfoVO selectById(Integer userId);
}