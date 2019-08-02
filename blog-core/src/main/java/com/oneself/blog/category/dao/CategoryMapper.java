package com.oneself.blog.category.dao;

import com.oneself.blog.category.entity.pojo.Category;
import java.util.List;

public interface CategoryMapper {

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/8/2 10:38
     * @Param [category]
     * @return void
     **/
    void insert(Category category);

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/8/2 10:39
     * @Param [categoryId]
     * @return void
     **/
    void deleteById(Integer categoryId);

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/8/2 10:39
     * @Param [category]
     * @return void
     **/
    void updateById(Category category);
}