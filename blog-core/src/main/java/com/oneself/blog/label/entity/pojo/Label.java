package com.oneself.blog.label.entity.pojo;

import com.oneself.blog.common.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

@Data
public class Label {

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
    private StatusEnum lableStatus;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Integer updateUser;

    /**
     * 修改时间
     */
    private Date udpateTime;

}