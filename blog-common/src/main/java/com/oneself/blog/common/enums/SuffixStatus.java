package com.oneself.blog.common.enums;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/5 18:19
 * @Version 1.0
 */
public enum SuffixStatus implements BaseEnum {
    //编号后缀状态（0：不加后缀  1：4位随机数后缀  2：编号后缀）
    NO_SUFFIX("0","不加后缀"),
    RANDOM_FOUR_NUMBER_SUFFIX("1","4位随机数后缀"),
    SQL_SUFFIX("2","编号后缀")
    ;

    private String value;
    private String name;

    SuffixStatus(String value,String name){
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
