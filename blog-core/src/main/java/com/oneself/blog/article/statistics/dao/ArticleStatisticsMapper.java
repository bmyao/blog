package com.oneself.blog.article.statistics.dao;

import com.oneself.blog.article.statistics.entity.pojo.ArticleStatistics;
import java.util.List;

public interface ArticleStatisticsMapper {

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/8/2 10:45
     * @Param [articleStatistics]
     * @return void
     **/
    void insert(ArticleStatistics articleStatistics);

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/8/2 10:45
     * @Param [articleStatisticsId]
     * @return void
     **/
    void deleteById(Integer articleStatisticsId);

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/8/2 10:52
     * @Param [articleStatistics]
     * @return void
     **/
    void updateById(ArticleStatistics articleStatistics);
}