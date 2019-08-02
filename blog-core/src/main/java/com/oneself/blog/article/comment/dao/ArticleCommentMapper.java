package com.oneself.blog.article.comment.dao;

import com.oneself.blog.article.comment.entity.pojo.ArticleComment;
import java.util.List;

public interface ArticleCommentMapper {

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/8/2 10:58
     * @Param [articleComment]
     * @return void
     **/
    void insert(ArticleComment articleComment);

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/8/2 10:59
     * @Param [articleCommentId]
     * @return void
     **/
    void deleteById(Integer articleCommentId);

}