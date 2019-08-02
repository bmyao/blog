package com.oneself.blog.system.user.service.impl;

import com.oneself.blog.common.enums.StatusEnum;
import com.oneself.blog.common.utils.GenerateCodeUtils;
import com.oneself.blog.common.utils.MapperUtils;
import com.oneself.blog.common.utils.PasswordUtils;
import com.oneself.blog.system.user.dao.UserMapper;
import com.oneself.blog.system.user.entity.pojo.User;
import com.oneself.blog.system.user.entity.qo.UserRegisterQO;
import com.oneself.blog.system.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/2 15:39
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/8/2 15:40
     * @Param [userRegisterQO]
     * @return void
     **/
    @Override
    public void registerUser(UserRegisterQO userRegisterQO) {
        //转换类
        User user = MapperUtils.mapperBean(userRegisterQO, User.class);
        //密码加密
        user.setLoginPassword(PasswordUtils.encrypt(user.getLoginName(), user.getLoginPassword()));
        //todo 生成编号的方法
        user.setUserCode(GenerateCodeUtils.generateShortUuid());
        user.setCreateTime(new Date());
        user.setStatus(StatusEnum.ENABLE);
        //新增user
        userMapper.insert(user);
    }
}
