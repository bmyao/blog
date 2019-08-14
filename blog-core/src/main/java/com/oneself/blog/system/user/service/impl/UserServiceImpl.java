package com.oneself.blog.system.user.service.impl;

import com.oneself.blog.common.enums.GenerateCodeEnum;
import com.oneself.blog.common.enums.StatusEnum;
import com.oneself.blog.common.utils.MapperUtils;
import com.oneself.blog.common.utils.PasswordUtils;
import com.oneself.blog.system.code.service.CodeService;
import com.oneself.blog.system.menu.entity.vo.MenuTreeVO;
import com.oneself.blog.system.menu.service.MenuService;
import com.oneself.blog.system.user.common.LoginUserSession;
import com.oneself.blog.system.user.dao.UserMapper;
import com.oneself.blog.system.user.entity.dto.LoginUserDTO;
import com.oneself.blog.system.user.entity.pojo.User;
import com.oneself.blog.system.user.entity.co.UserRegisterCO;
import com.oneself.blog.system.user.entity.vo.LoginUserVO;
import com.oneself.blog.system.user.entity.vo.UserInfoVO;
import com.oneself.blog.system.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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

    @Resource
    private CodeService codeService;

    @Resource
    private MenuService menuService;

    @Resource
    private LoginUserSession loginUserSession;

    /**
     * @Author liangjiayao
     * @Description 注册用户
     * @Date 2019/8/2 15:40
     * @Param [userRegisterQO]
     * @return void
     **/
    @Override
    public void registerUser(UserRegisterCO userRegisterCO) {
        //转换类
        User user = MapperUtils.mapperBean(userRegisterCO, User.class);
        //密码加密
        user.setLoginPassword(PasswordUtils.encrypt(user.getLoginName(), user.getLoginPassword()));
        user.setUserCode(codeService.getCode(GenerateCodeEnum.USER));
        user.setCreateTime(new Date());
        user.setStatus(StatusEnum.ENABLE);
        //新增user
        userMapper.insert(user);
    }

    /**
     * @Author liangjiayao
     * @Description 登录后的用户信息和菜单
     * @Date 2019/8/14 11:05
     * @Param []
     * @return com.oneself.blog.system.user.entity.vo.LoginUserVO
     **/
    @Override
    public LoginUserVO findLoginUserAndMenu() {
        LoginUserDTO user = loginUserSession.getCurrentUser();
        //查询用户信息
        UserInfoVO userInfoVO = userMapper.selectById(user.getUserId());
        //查询登录用户的菜单
        List<MenuTreeVO> loginMenu = menuService.findMenusByUserId(user.getUserId());
        //转换返回类
        LoginUserVO loginUserVO = MapperUtils.mapperBean(userInfoVO, LoginUserVO.class);
        loginUserVO.setLoginMenu(loginMenu);
        return loginUserVO;
    }
}
