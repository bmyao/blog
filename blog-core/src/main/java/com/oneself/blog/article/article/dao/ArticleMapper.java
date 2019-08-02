package com.oneself.blog.article.article.dao;

import com.oneself.blog.article.article.entity.pojo.Article;

public interface ArticleMapper {

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/8/2 11:08
     * @Param [article]
     * @return void
     **/
    void insert(Article article);

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/8/2 11:08
     * @Param [articleId]
     * @return void
     **/
    void deleteById(Integer articleId);

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/8/2 11:13
     * @Param [article]
     * @return void
     **/
    void updateById(Article article);
}