package com.oneself.blog.common.enums;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/5 18:02
 * @Version 1.0
 */
public enum GenerateCodeEnum {

    USER("user","用户")
    ;

    private String value;
    private String name;

    GenerateCodeEnum(String value, String name){
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }


}