package com.oneself.blog.system.user.entity.qo;

import com.oneself.blog.common.enums.SexEnum;
import com.oneself.blog.common.enums.StatusEnum;
import lombok.Data;


/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/25 15:15
 * @Version 1.0
 */
@Data
public class UserListQO {

    /**
     * 用户编号或者用户名字
     */
    private String item;

    /**
     * 用户性别（ 0:男  1:女  2:保密 ）
     */
    private SexEnum userSex;

    /**
     * 用户状态（ 0:禁止  1:启用 ）
     */
    private StatusEnum status;

}
