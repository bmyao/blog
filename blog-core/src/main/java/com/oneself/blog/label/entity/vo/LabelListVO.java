package com.oneself.blog.label.entity.vo;

import com.oneself.blog.common.enums.StatusEnum;
import com.oneself.blog.common.utils.EnumUtils;
import lombok.Data;

import java.util.Date;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/24 15:56
 * @Version 1.0
 */
@Data
public class LabelListVO {

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

    /**
     * 标签状态（ 0:禁止  1:启用 ）
     */
    private String lableStatus;

    /**
     * 标签状态（ 0:禁止  1:启用 ）
     */
    private String lableStatusName;

    /**
     * 创建人
     */
    private String createUserName;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改人
     */
    private String updateUserName;

    /**
     * 修改时间
     */
    private String udpateTime;

    public String getLableStatusName() {
        return EnumUtils.getByValue(StatusEnum.class,lableStatus).getName();
    }
}
