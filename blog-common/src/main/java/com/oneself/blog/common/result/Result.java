package com.oneself.blog.common.result;

import com.alibaba.fastjson.JSON;
import com.oneself.blog.common.enums.ResultCodeEnum;
import lombok.Data;

/**
 * @Describe 统一返回类
 * @Author: liangjiayao
 * @Date: 2019/8/2 11:27
 * @Version 1.0
 */
@Data
public class Result<T> {
    
    /**
     *  状态枚举
     **/
    private ResultCodeEnum code;

    /**
     *  消息
     **/
    private String message;

    /**
     *  内容
     **/
    private T data;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public Integer getCode() {
        return code.getValue();
    }
}
