package com.oneself.blog.label.entity.qo;

import com.oneself.blog.common.enums.StatusEnum;
import lombok.Data;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/24 17:17
 * @Version 1.0
 */
@Data
public class LabelListQO {

    /**
     * 状态（ 0:禁止  1:启用 ）
     **/
    private StatusEnum lableStatus;

    /**
     * 模糊查询（code或者name）
     **/
    private String item;
}
