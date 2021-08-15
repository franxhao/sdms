package com.hqyj.twelve.realm;

import com.hqyj.twelve.pojo.Administrator;
import com.hqyj.twelve.pojo.Employee;
import com.hqyj.twelve.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: GP
 * @date: 2021/8/12-14:19
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

    //给shiro框架返回系统中待认证用户的认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        MyAuthenticationToken token = (MyAuthenticationToken)authenticationToken;//强转为自定义token

        //在shiro的会话域中共享，以便业务层获取使用
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        //使用认证令牌获取当前待登录的用户名
        String username = (String)token.getPrincipal();

        SimpleAuthenticationInfo info = null;

        //如果flag==admin,说明是管理员在登录
        if(token.getFlag().equals("admin")){
            //在我们的管理员数据库中查询用户的认证信息
            Administrator admin = adminService.queryAdminByUsername(username);
            if(admin == null){
                    throw new UnknownAccountException(username+"不存在");
            }
            session.setAttribute("user",admin);

            //加密
            ByteSource saltBytes = ByteSource.Util.bytes(admin.getAdUsername());
             info = new SimpleAuthenticationInfo(username,admin.getAdPassword(),saltBytes,getName());

        }

        //如果flag==emp,说明是普通用户在登录
        if(token.getFlag().equals("emp")){
            //在我们的管理员数据库中查询用户的认证信息
            Employee emp = adminService.queryEmpByUsername(username);
            if(emp == null){
                throw new UnknownAccountException(username+"不存在");
            }
            session.setAttribute("user",emp);

            //加密
            ByteSource saltBytes = ByteSource.Util.bytes(emp.getEmpUsername());
             info = new SimpleAuthenticationInfo(username,emp.getEmpPassword(),saltBytes,getName());
        }
        System.out.println("获取认证信息");
        return info;
    }



    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

    return null;
    }

    @Override
    public boolean supports(AuthenticationToken token){
        return token != null && token instanceof MyAuthenticationToken;
    }

}
