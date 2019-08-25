package com.oneself.blog.comment.entity.pojo;

import com.oneself.blog.common.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

@Data
public class Comment {

    /**
     * 评论ID
     */
    private Integer commentId;

    /**
     * 父评论ID
     */
    private Integer parentId;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论时IP
     */
    private String commentIp;

    /**
     * 评论状态（ 0:禁止  1:启用 ）
     */
    private StatusEnum commentStatus;

    /**
     * 被评论人
     */
    private Integer belongUser;

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
    private Date updateTime;

}
