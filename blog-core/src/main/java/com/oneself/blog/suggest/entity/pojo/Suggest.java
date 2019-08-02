package com.oneself.blog.suggest.entity.pojo;

import com.oneself.blog.common.enums.StatusEnum;
import com.oneself.blog.common.enums.SuggestStatusEnum;
import lombok.Data;

import java.util.Date;

@Data
public class Suggest {

    /**
     * 意见ID
     */
    private Integer suggestId;

    /**
     * ip地址
     */
    private String userIp;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 意见状态（ 0:废弃  1:不予理会  3:有兴趣纳入目标  4:采纳正在做  6:已经完成 ）
     */
    private SuggestStatusEnum  suggestStatus;

    /**
     * 显示状态（ 0:禁止  1:启用 ）
     */
    private StatusEnum displayStatus;

    /**
     * 意见内容
     */
    private String suggestContent;

}