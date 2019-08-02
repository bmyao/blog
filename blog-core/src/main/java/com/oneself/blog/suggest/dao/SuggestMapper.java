package com.oneself.blog.suggest.dao;

import com.oneself.blog.suggest.entity.pojo.Suggest;
import java.util.List;

public interface SuggestMapper {

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/8/2 9:52
     * @Param [record]
     * @return void
     **/
    void insert(Suggest suggest);
    
    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/8/2 9:52
     * @Param [suggestId]
     * @return void
     **/
    void deleteById(Integer suggestId);

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/8/2 9:52
     * @Param [record]
     * @return void
     **/
    void updateById(Suggest suggest);
}