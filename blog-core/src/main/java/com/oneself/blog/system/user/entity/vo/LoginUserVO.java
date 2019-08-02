package com.oneself.blog.system.user.entity.vo;

import lombok.Data;


/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/2 14:36
 * @Version 1.0
 */
@Data
public class LoginUserVO<T> {
    
    /**
     *  登录token
     **/
    private T token;

}
