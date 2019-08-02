package com.oneself.blog.common.enums;

/**
 * @Author liangjiayao
 * @Description
 * @Date 2019/6/12 15:52
 * @Param 
 * @return 
 **/
public interface BaseEnum<T> {
    T getValue();
    String getName();
}
