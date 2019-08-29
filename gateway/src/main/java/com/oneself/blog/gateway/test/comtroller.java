package com.oneself.blog.gateway.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/27 9:29
 * @Version 1.0
 */
@Api(value = "测试", tags = "测试")
@Controller
@RequestMapping("/test")
public class comtroller {

    @ApiOperation(value = "测试1", notes = "测试1")
    @GetMapping("/get")
    public String register(){
        return "测试成功";
    }
}
