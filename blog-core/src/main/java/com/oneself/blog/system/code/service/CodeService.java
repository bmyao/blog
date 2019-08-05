package com.oneself.blog.system.code.service;

import com.oneself.blog.common.enums.GenerateCodeEnum;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/5 17:56
 * @Version 1.0
 */
public interface CodeService {

    /**
     * 获取编号
     * */
    String getCode(GenerateCodeEnum codeEnum);
}
