package com.oneself.blog.system.user.entity.vo;

import com.oneself.blog.system.menu.entity.vo.MenuTreeVO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/14 11:01
 * @Version 1.0
 */
@Data
public class LoginUserVO extends UserInfoVO {

    /**
     * 登录菜单
     **/
    private List<MenuTreeVO> loginMenu = new ArrayList<>();
}
