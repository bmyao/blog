package com.oneself.blog.system.user.controller;

import com.oneself.blog.common.result.Result;
import com.oneself.blog.common.result.ResultGenerator;
import com.oneself.blog.system.user.entity.co.UserRegisterCO;
import com.oneself.blog.system.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/2 15:24
 * @Version 1.0
 */
@Api(value = "用户操作", tags = "用户操作")
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "用户注册", notes = "用户注册")
    @PostMapping("/register")
    public Result register(@Valid @RequestBody UserRegisterCO userRegisterCO){
        userService.registerUser(userRegisterCO);
        return ResultGenerator.genSuccessResult("注册成功");
    }
}
