package com.oneself.blog.common.enums;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/2 9:58
 * @Version 1.0
 */
public enum SuggestStatusEnum implements BaseEnum {
    //意见状态（ 0:废弃  1:不予理会  3:有兴趣纳入目标  4:采纳正在做  6:已经完成 ）
    DISCARD("0","废弃"),
    IGNORE("1","不予理会"),
    INCORPORATE_GOALS("3","纳入目标"),
    DOING("4","采纳正在做"),
    COMPLETE("6","已经完成")
    ;

    private String value;
    private String name;

    SuggestStatusEnum(String value,String name){
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
