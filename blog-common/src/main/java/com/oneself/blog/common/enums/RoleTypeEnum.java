package com.oneself.blog.common.enums;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/25 17:45
 * @Version 1.0
 */
public enum RoleTypeEnum implements BaseEnum {
    SUPER_ADMIN("0","超级管理员"),
    ADMIN("1","普通管理员"),
    ORDINARY("2","普通用户")
    ;

    private String value;
    private String name;

    RoleTypeEnum(String value,String name){
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
