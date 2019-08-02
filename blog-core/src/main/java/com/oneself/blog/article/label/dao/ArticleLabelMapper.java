package com.oneself.blog.article.label.dao;

import com.oneself.blog.article.label.entity.pojo.ArticleLabel;
import java.util.List;

public interface ArticleLabelMapper {

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/8/2 10:54
     * @Param [articleLabel]
     * @return void
     **/
    void insert(ArticleLabel articleLabel);

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/8/2 10:54
     * @Param [articleLabelId]
     * @return void
     **/
    void deleteById(Integer articleLabelId);
}