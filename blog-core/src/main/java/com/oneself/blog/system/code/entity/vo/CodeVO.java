package com.oneself.blog.system.code.entity.vo;

import lombok.Data;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/5 17:43
 * @Version 1.0
 */
@Data
public class CodeVO {

    /**
     * 编号key值
     */
    private String codeKey;

    /**
     * 编号前缀
     */
    private String codePrefix;

    /**
     * 编号值
     */
    private Long codeValue;

    /**
     * 值自增数
     */
    private Integer increaseValue;

    /**
     * 编号后缀状态（0：不加后缀  1：4位随机数后缀  2：编号后缀）
     */
    private String suffixStatus;

    /**
     * 编号后缀
     */
    private String codeSuffix;
}
