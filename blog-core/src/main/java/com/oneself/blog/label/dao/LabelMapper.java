package com.oneself.blog.label.dao;

import com.oneself.blog.label.entity.pojo.Label;
import com.oneself.blog.label.entity.co.LabelListCO;
import com.oneself.blog.label.entity.vo.LabelListVO;
import com.oneself.blog.label.entity.vo.LabelOptionVO;

import java.util.List;

public interface LabelMapper {

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/7/24 10:50
     * @Param [record]
     * @return void
     **/
    void insert(Label label);
    
    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/7/24 11:21
     * @Param [labelId]
     * @return void
     **/
    void deleteById(Integer labelId);

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/7/24 11:33
     * @Param [label]
     * @return void
     **/
    void updateById(Label label);

    /**
     * @Author liangjiayao
     * @Description 列表查询
     * @Date 2019/7/24 17:44
     * @Param [labelListCO]
     * @return com.oneself.blog.label.entity.vo.LabelListVO
     **/
    List<LabelListVO> findListByCondition(LabelListCO labelListCO);

    /**
     * @Author liangjiayao
     * @Description 下拉框查询
     * @Date 2019/7/25 9:42
     * @Param []
     * @return java.util.List<com.oneself.blog.label.entity.vo.LabelOptionVO>
     **/
    List<LabelOptionVO> findOption();
}