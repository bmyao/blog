package com.oneself.blog.category.entity.pojo;

import com.oneself.blog.common.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

@Data
public class Category {

    /**
     * 分类ID
     */
    private Integer categoryId;

    /**
     * 父分类ID
     */
    private Integer parentId;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 分类排序
     */
    private Integer categorySort;

    /**
     * 分类状态（ 0:禁止  1:启用 ）
     */
    private StatusEnum categoryStatus;

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