package com.oneself.blog.common.shiro;

import com.oneself.blog.common.enums.StatusEnum;
import com.oneself.blog.system.menu.dao.MenuMapper;
import com.oneself.blog.system.role.dao.RoleMapper;
import com.oneself.blog.system.role.entity.dto.LoginRoleDTO;
import com.oneself.blog.system.user.dao.UserMapper;
import com.oneself.blog.system.user.entity.dto.LoginUserDTO;
import com.oneself.blog.system.user.entity.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Describe
 * @Author: liangjiayao
 * @Date: 2019/7/29 10:17
 * @Version 1.0
 */
@Component
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private MenuMapper menuMapper;

    /**
     * @Author liangjiayao
     * @Description 授权（验证权限的时候调用）
     * @Date 2019/7/29 10:29
     * @Param [principalCollection]
     * @return org.apache.shiro.authz.AuthorizationInfo
     *
     * 授权的方法是在碰到<shiro:hasPermission name=''></shiro:hasPermission>标签的时候调用的
     * 它会去检测shiro框架中的权限(这里的permissions)是否包含有该标签的name值,如果有,里面的内容显示
     * 如果没有,里面的内容不予显示(这就完成了对于权限的认证.)
     *
     * shiro的权限授权是通过继承AuthorizingRealm抽象类，重载doGetAuthorizationInfo();
     * 当访问到页面的时候，链接配置了相应的权限或者shiro标签才会执行此方法否则不会执行
     * 所以如果只是简单的身份认证没有权限的控制的话，那么这个方法可以不进行实现，直接返回null即可。
     *
     * 在这个方法中主要是使用类：SimpleAuthorizationInfo 进行角色的添加和权限的添加。
     * authorizationInfo.addRole(role.getRole()); authorizationInfo.addStringPermission(p.getPermission());
     *
     * 当然也可以添加set集合：roles是从数据库查询的当前用户的角色，stringPermissions是从数据库查询的当前用户对应的权限
     * authorizationInfo.setRoles(roles); authorizationInfo.setStringPermissions(stringPermissions);
     *
     * 就是说如果在shiro配置文件中添加了filterChainDefinitionMap.put("/add", "perms[权限添加]");
     * 就说明访问/add这个链接必须要有“权限添加”这个权限才可以访问
     *
     * 如果在shiro配置文件中添加了filterChainDefinitionMap.put("/add", "roles[100002]，perms[权限添加]");
     * 就说明访问/add这个链接必须要有 "权限添加" 这个权限和具有 "100002" 这个角色才可以访问
     *
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        /* 另一种写法
        //添加角色
        SimpleAuthorizationInfo authorizationInfo =  new SimpleAuthorizationInfo();
        for (Role role : roles) {
            authorizationInfo.addRole(role.getRole());
        }
        //获取用户权限
        Set<Permission> permissions = this.permissionMapper.findPermissionsByRoleId(roles);
        //添加权限
        for (Permission permission:permissions) {
            authorizationInfo.addStringPermission(permission.getPermission());
        }
        */
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //角色
        List<LoginRoleDTO> roles = roleMapper.findRolesByUserId(user.getUserId());
        Set<String> roleSet = roles.stream().map(LoginRoleDTO::getRoleName).collect(Collectors.toSet());
        simpleAuthorizationInfo.setRoles(roleSet);

        // 获取用户权限集-->菜单perms
        Set<String> permissionSet = menuMapper.selectMenuPermsByUserId(user.getUserId());
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }

    /**
     * @Author liangjiayao
     * @Description 用户认证（登录的时候调用）
     * @Date 2019/7/29 10:29
     * @Param [authenticationToken]
     * @return org.apache.shiro.authc.AuthenticationInfo
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户名密码 第一种方式
        //String loginName = (String) authenticationToken.getPrincipal();
        //String loginPassword = new String((char[]) authenticationToken.getCredentials());

        //获取用户名 密码 第二种方式
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String loginName = usernamePasswordToken.getUsername();
        String loginPassword = new String(usernamePasswordToken.getPassword());
        //通过账号密码查询user然后判断
        LoginUserDTO user = userMapper.selectUserByLoginNameAndPasswork(loginName, loginPassword);
        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (StatusEnum.DISABLE.getValue().equals(user.getStatus())) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }
        //登录后user会缓存到session
        return new SimpleAuthenticationInfo(user, loginPassword, getName());
    }
}
