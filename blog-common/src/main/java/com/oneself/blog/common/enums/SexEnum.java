package com.oneself.blog.common.enums;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/25 14:59
 * @Version 1.0
 */
public enum SexEnum implements BaseEnum {
    WOMEN("1","男"),
    MEN("0","女"),
    UNKNOWN("2", "保密")
    ;

    private String value;
    private String name;

    SexEnum(String value,String name){
        this.value = value;
        this.name = name;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name;
    }
}
