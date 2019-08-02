package com.oneself.blog.article.article.entity.pojo;

import com.oneself.blog.common.enums.PublishStatusEnum;
import lombok.Data;

import java.util.Date;

@Data
public class Article {

    /**
     * 文章ID
     */
    private Integer articleId;

    /**
     * 文章code
     */
    private String articleCode;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章封面URL
     */
    private String articleCoverUrl;

    /**
     * 文章描述
     */
    private String articleDescription;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 分类ID
     */
    private Integer categoryId;

    /**
     * 推荐文章
     */
    private String recommend;

    /**
     * 推荐排序
     */
    private Integer recommendSort;

    /**
     * 发布状态（ 0:未发布  1:已发布  9:禁止发布 ）
     */
    private PublishStatusEnum publishStatus;

    /**
     * 创建人（作者）
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