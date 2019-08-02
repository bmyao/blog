package com.oneself.blog.common.enums;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/2 11:01
 * @Version 1.0
 */
public enum PublishStatusEnum implements BaseEnum {
    //发布状态（ 0:未发布  1:已发布  9:禁止发布 ）
    UNPUBLISHED("0","未发布"),
    PUBLISHING("1","已发布"),
    PROHIBIT_PUBLISHING("2","禁止发布")
    ;

    private String value;
    private String name;

    PublishStatusEnum(String value,String name){
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
