package com.oneself.blog.system.user.controller;

import com.oneself.blog.common.result.Result;
import com.oneself.blog.common.result.ResultGenerator;
import com.oneself.blog.common.utils.PasswordUtils;
import com.oneself.blog.system.user.entity.qo.LoginQO;
import com.oneself.blog.system.user.entity.vo.LoginUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/1 17:22
 * @Version 1.0
 */
@Api(value = "用户登录", tags = "用户登录")
@RestController
public class LoginController {


    @ApiOperation(value = "用户登录", notes = "用户登录")
    @PostMapping(value = "/login")
    public Result login(@Valid @RequestBody LoginQO loginQO) {
        String username = loginQO.getUsername();
        String password = loginQO.getPassword();
        boolean rememberMe = loginQO.getRememberMe();
        //  AES 加密
        password = PasswordUtils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        try {
            Subject subject = SecurityUtils.getSubject();
            if (subject != null) {
                subject.logout();
            }
            //登录
            subject.login(token);
            LoginUserVO loginUserVO = new LoginUserVO();
            loginUserVO.setToken(subject.getSession().getId());
            return ResultGenerator.genSuccessResult(loginUserVO);
        } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
            return ResultGenerator.genFailResult(e.getMessage());
        } catch (AuthenticationException e) {
            return ResultGenerator.genFailResult("认证失败！");
        }
    }

    @ApiIgnore
    @GetMapping("/login")
    public Result login() {
        return ResultGenerator.genFailResult("未登录");
    }

    @ApiOperation(value = "用户登出", notes = "用户登出")
    @GetMapping("/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
            return ResultGenerator.genFailResult("登出成功");
        } else {
            return ResultGenerator.genFailResult("未登录");
        }
    }
}
