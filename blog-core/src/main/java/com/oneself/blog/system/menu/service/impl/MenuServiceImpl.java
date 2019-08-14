package com.oneself.blog.system.menu.service.impl;

import com.oneself.blog.common.enums.StatusEnum;
import com.oneself.blog.common.utils.MapperUtils;
import com.oneself.blog.system.menu.dao.MenuMapper;
import com.oneself.blog.system.menu.entity.co.MenuAddCO;
import com.oneself.blog.system.menu.entity.co.MenuEditCO;
import com.oneself.blog.system.menu.entity.co.MenuListCO;
import com.oneself.blog.system.menu.entity.pojo.Menu;
import com.oneself.blog.system.menu.entity.vo.MenuListVO;
import com.oneself.blog.system.menu.entity.vo.MenuTreeVO;
import com.oneself.blog.system.menu.entity.vo.RoleMenuTreeVO;
import com.oneself.blog.system.menu.service.MenuService;
import com.oneself.blog.system.role.dao.RoleMenuMapper;
import com.oneself.blog.system.user.common.LoginUserSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/8/10 12:00
 * @Version 1.0
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Resource
    private LoginUserSession loginUserSession;

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/8/10 12:00
     * @Param [menuAddCO]
     * @return void
     **/
    @Override
    public void addMenu(MenuAddCO menuAddCO) {
        //code让前端处理继承父类code后在后面加-自己code
        Menu menu = MapperUtils.mapperBean(menuAddCO, Menu.class);
        //处理一下perms
        String perms = menuAddCO.getMenuCode().replace("-", ":");
        menu.setPerms(perms);
        menu.setStatus(StatusEnum.ENABLE);
        menu.setCreateTime(new Date());
        menu.setCreateUser(loginUserSession.getCurrentUser().getUserId());
        menuMapper.insert(menu);
    }

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/8/10 12:00
     * @Param [menuCode]
     * @return void
     **/
    @Override
    public void removeMenu(String menuCode) {
        menuMapper.deleteByCode(menuCode);
    }

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/8/10 12:01
     * @Param [menuEditCO]
     * @return void
     **/
    @Override
    public void editMenu(MenuEditCO menuEditCO) {
        Menu menu = MapperUtils.mapperBean(menuEditCO, Menu.class);
        menu.setUpdateTime(new Date());
        menu.setUpdateUser(loginUserSession.getCurrentUser().getUserId());
        menuMapper.updateByCode(menu);
    }

    /**
     * @Author liangjiayao
     * @Description 启动菜单状态
     * @Date 2019/8/14 10:04
     * @Param [menuCode]
     * @return void
     **/
    @Override
    public void editMenuEnableStatus(String menuCode) {
        //公共方法
        editMenuStatus(menuCode,StatusEnum.ENABLE);
    }

    /**
     * @Author liangjiayao
     * @Description 禁止菜单状态
     * @Date 2019/8/14 10:04
     * @Param [menuCode]
     * @return void
     **/
    @Override
    public void editMenuDisableStatus(String menuCode) {
        //公共方法
        editMenuStatus(menuCode,StatusEnum.DISABLE);
    }

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/8/10 12:01
     * @Param [menuListCO]
     * @return java.util.List<com.oneself.blog.system.menu.entity.vo.MenuListVO>
     **/
    @Override
    public List<MenuListVO> findListByCondition(MenuListCO menuListCO) {
        return menuMapper.selectListByCondition(menuListCO);
    }

    /**
     * @Author liangjiayao
     * @Description 登录的菜单
     * @Date 2019/8/10 12:01
     * @Param [userId]
     * @return java.util.List<com.oneself.blog.system.menu.entity.vo.MenuTreeVO>
     **/
    @Override
    public List<MenuTreeVO> findMenusByUserId(Integer userId) {
        //最终返回的菜单集合
        List<MenuTreeVO> list = new ArrayList<>();
        //通过id查询已选菜单
        List<MenuTreeVO> menuTreeVOS = menuMapper.selectMenusByUserId(userId);
        //处理数据
        menuTreeVOS.forEach(menuTreeVO -> {
            String pid = menuTreeVO.getParentCode();
            //如果是父菜单就会直接添加然后return匿名内部这次循环
            if (StringUtils.isBlank(pid)) {
                list.add(menuTreeVO);
                return;
            }
            //如果是子菜单或者按钮就循环判断对比code存进对应父菜单的list
            for (MenuTreeVO menu : menuTreeVOS) {
                String id = menu.getMenuCode();
                if (id.equals(pid)) {
                    menu.getList().add(menu);
                    menu.setChildList(true);
                    return;
                }
            }
        });
        return list;
    }

    /**
     * @Author liangjiayao
     * @Description 角色的权限菜单
     * @Date 2019/8/10 12:01
     * @Param [roleId]
     * @return java.util.List<com.oneself.blog.system.menu.entity.vo.RoleMenuTreeVO>
     **/
    @Override
    public List<RoleMenuTreeVO> findMenuByRoleId(Integer roleId) {
        //最终返回的菜单集合
        List<RoleMenuTreeVO> list = new ArrayList<>();
        //查询所有菜单
        List<RoleMenuTreeVO> allMenu = menuMapper.selectAllMenuByEnable();
        //通过id查询已有菜单
        List<String> menuCodeList = roleMenuMapper.selectMenuByRoleId(roleId);
        //处理数据
        allMenu.forEach(menuTreeVO -> {
            String pid = menuTreeVO.getParentCode();
            //判断菜单是否是已有菜单
            if(menuCodeList.contains(menuTreeVO.getMenuCode())){
                //已选角色权限
                menuTreeVO.setCheckbox(true);
            }
            //如果是父菜单就会直接添加然后return匿名内部这次循环
            if (StringUtils.isBlank(pid)) {
                list.add(menuTreeVO);
                return;
            }
            //如果是子菜单或者按钮就循环判断对比code存进对应父菜单的list
            for (RoleMenuTreeVO menu : allMenu) {
                String id = menu.getMenuCode();
                if (id.equals(pid)) {
                    menu.getList().add(menu);
                    menu.setChildList(true);
                    return;
                }
            }
        });
        return list;
    }


    /**
     * @Author liangjiayao
     * @Description 修改菜单公共状态方法
     * @Date 2019/8/14 10:03
     * @Param [menuCode, statusEnum]
     * @return void
     **/
    private void editMenuStatus(String menuCode,StatusEnum statusEnum){
        Menu menu = new Menu();
        menu.setMenuCode(menuCode);
        menu.setStatus(statusEnum);
        menu.setUpdateTime(new Date());
        menu.setUpdateUser(loginUserSession.getCurrentUser().getUserId());
        menuMapper.updateStatus(menu);
    }

}
