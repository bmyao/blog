package com.oneself.blog.article.label.entity.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleLabel {

    /**
     * 文章标签ID
     */
    private Integer articleLabelId;

    /**
     * 文章ID
     */
    private Integer articleId;

    /**
     * 标签ID
     */
    private Integer labelId;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 创建时间
     */
    private Date createTime;

}