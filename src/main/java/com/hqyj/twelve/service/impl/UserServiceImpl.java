package com.hqyj.twelve.service.impl;

import com.hqyj.twelve.realm.MyAuthenticationToken;
import com.hqyj.twelve.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: GP
 * @date: 2021/8/15-9:03
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public Map<String, Object> loginAdmin(String username, String password) {
        String flag="admin";
        Map<String,Object> result = new HashMap<>();
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //判断当前用户是否已经认证过
        if (!subject.isAuthenticated()) {
            //创建一个认证令牌
            MyAuthenticationToken token = new MyAuthenticationToken(
                    username, password.toCharArray(),flag);
            //没有认证，做登录操作
            try {
                subject.login(token);
            } catch (UnknownAccountException e) {
                e.printStackTrace();
                //未知账号异常
                result.put("code",-1);
                result.put("message",username+"用户不存在");
                return result;
            }catch (IncorrectCredentialsException e){
                //密码错误异常
                result.put("code",-2);
                result.put("message",username+"用户密码错误");
                return result;
            }catch (AuthenticationException e){
                result.put("code",-10);
                result.put("message","认证失败");
                return result;
            }
        }
        //认证通过
        result.put("code",0);
        result.put("message","认证成功");
        //获取已保存在shiro session域中的用户信息，存入result中
        result.put("user",subject.getSession().getAttribute("user"));
        return result;
    }

    @Override
    public Map<String, Object> loginEmp(String username, String password) {
        String flag="emp";
        Map<String,Object> result = new HashMap<>();
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //判断当前用户是否已经认证过
        if (!subject.isAuthenticated()) {
            //创建一个认证令牌
            MyAuthenticationToken token = new MyAuthenticationToken(
                    username, password.toCharArray(),flag);

            //没有认证，做登录操作
            try {
                subject.login(token);
            } catch (UnknownAccountException e) {
                e.printStackTrace();
                //未知账号异常
                result.put("code",-1);
                result.put("message",username+"用户不存在");
                return result;
            }catch (IncorrectCredentialsException e){
                //密码错误异常
                result.put("code",-2);
                result.put("message",username+"用户密码错误");
                return result;
            }catch (AuthenticationException e){
                result.put("code",-10);
                result.put("message","认证失败");
                return result;
            }
        }
        //认证通过
        result.put("code",0);
        result.put("message","认证成功");
        //获取已保存在shiro session域中的用户信息，存入result中
        result.put("user",subject.getSession().getAttribute("user"));
        return result;
    }

    @Override
    public void logout() {
        //使用shiro框架获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //使用shiro对当前用户注销
        subject.logout();
    }
}
