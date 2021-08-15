package com.hqyj.twelve.service;

import java.util.Map;

/**
 * @description:
 * @author: GP
 * @date: 2021/8/15-9:03
 */
public interface UserService {
    //管理员登录
    Map<String,Object> loginAdmin(String username ,String password);


    //普通用户登录
    Map<String,Object> loginEmp(String username ,String password);

    //注销功能
    void logout();
}
