package com.oneself.blog.article.comment.entity.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleComment {

    /**
     * 文章评论ID
     */
    private Integer articleCommentId;

    /**
     * 文章ID
     */
    private Integer articleId;

    /**
     * 评论ID
     */
    private Integer commentId;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 创建时间
     */
    private Date createTime;

}