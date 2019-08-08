package com.oneself.blog.system.user.entity.co;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/2 13:39
 * @Version 1.0
 */
@Data
public class LoginCO {

    @NotEmpty(message = "账号不能为空")
    private String username;

    @NotEmpty(message = "密码不能为空")
    private String password;

    @NotNull(message = "是否记住密码选项不能为空")
    private Boolean rememberMe;
}
