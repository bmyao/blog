package com.oneself.blog.label.entity.vo;

import lombok.Data;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/25 9:40
 * @Version 1.0
 */
@Data
public class LabelOptionVO {

    /**
     * 标签ID
     */
    private Integer labelId;

    /**
     * 标签code
     */
    private String labelCode;

    /**
     * 标签名字
     */
    private String labelName;

}
