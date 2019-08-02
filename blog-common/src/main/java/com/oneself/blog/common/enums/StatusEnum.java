package com.oneself.blog.common.enums;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/24 17:45
 * @Version 1.0
 */
public enum StatusEnum implements BaseEnum {
    DISABLE("0","禁用"),
    ENABLE("1","启用")
    ;

    private String value;
    private String name;

    StatusEnum(String value,String name){
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
