package com.oneself.blog.image.dao;

import com.oneself.blog.image.entity.pojo.Image;
import java.util.List;

public interface ImageMapper {

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/8/2 10:14
     * @Param [image]
     * @return void
     **/
    void insert(Image image);

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/8/2 10:14
     * @Param [imageId]
     * @return void
     **/
    void deleteById(Integer imageId);
    
    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/8/2 10:14
     * @Param [image]
     * @return void
     **/
    void updateById(Image image);
}