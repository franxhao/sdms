package com.hqyj.twelve.controller;

import com.hqyj.twelve.service.AdminService;
import com.hqyj.twelve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 用于账户的登录登出
 * @author: GP
 * @date: 2021/8/15-8:54
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *
     * @param username
     * @param password
     * @param flag  1为管理员，2为普通员工
     * @return
     */
    @RequestMapping("/login")
    public String login(String username ,String password,String flag,HttpServletResponse resp){
//        检查请求参数
        if(username == null || password == null || flag == null){
            return "redirect:/login.jsp";
        }
        Map<String, Object> map = new HashMap<>();
        //调用业务层实现业务
        if(Integer.parseInt(flag) == 1){
            //调用管理员数据库查询
           map = userService.loginAdmin(username, password);
        }else if(Integer.parseInt(flag) == 2){
            //调用普通用户emp数据库查询
           map=  userService.loginEmp(username,password);
        }
        Integer code =(Integer) map.get("code");
        if( code == 0){
            //数据库存在该用户，将账号和密码都保存到Cookie中
            Cookie cookie = new Cookie("name",username);
            Cookie cookie2 = new Cookie("password",password);
            cookie.setMaxAge(60*60*24*7);//设置一周的有效时间
            cookie2.setMaxAge(60*60*24*7);//设置一周的有效时间
            //将cookie发送到浏览器
            resp.addCookie(cookie);
            resp.addCookie(cookie2);
           return "main";
       }
       return "redirect:/login.jsp";
    }


    @RequestMapping("/logout")
    public String logout(){
         userService.logout();
      return "redirect:/login.jsp";
    }

}