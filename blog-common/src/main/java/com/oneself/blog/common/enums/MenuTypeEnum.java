package com.oneself.blog.common.enums;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/26 17:06
 * @Version 1.0
 */
public enum MenuTypeEnum implements BaseEnum {
    MENU("MENU","菜单"),
    BUTTON("BUTTON","按钮")
    ;

    private String value;
    private String name;

    MenuTypeEnum(String value,String name){
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
