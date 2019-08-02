package com.oneself.blog.article.statistics.entity.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleStatistics {

    /**
     * 文章统计ID
     */
    private Integer articleStatisticsId;

    /**
     * 文章ID
     */
    private Integer articleId;

    /**
     * 点赞数量
     */
    private Integer likeQuantity;

    /**
     * 阅读数量
     */
    private Integer readQuantity;

    /**
     * 评论数量
     */
    private Integer commentQuantity;

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