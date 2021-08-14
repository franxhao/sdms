package com.hqyj.twelve.controller;

import com.hqyj.twelve.pojo.Administrator;
import com.hqyj.twelve.service.AdminService;
import com.hqyj.twelve.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @description:
 * @author: GP
 * @date: 2021/8/13-10:48
 */
@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/list")
    //查询所有管理员用户
    public  String queryAllAdmin(ModelMap modelMap){
        List<Administrator> adminList = adminService.queryAllAdmin();
        modelMap.addAttribute("adminList",adminList);
        return "adminManagement";
    }

    @RequestMapping("/queryAdminById")
    @ResponseBody
    //通过id查询单个管理员用户（返回json数据）
    public  Administrator queryById(int id,ModelMap map){
        Administrator administrator = adminService.queryAdminById(id);
        return  administrator;
    }


    @RequestMapping("/addAdmin")
    @ResponseBody
    //添加管理员
    public void addPage(Administrator admin){
        ModelMap map=new ModelMap();
        //通过shiro框架加密密码
        String hashPassword = MD5Util.Md5Hash(admin.getAdPassword(), admin.getAdUsername());
        //将加密密码再次存入admin中。
        admin.setAdPassword(hashPassword);
        int num = adminService.addAdmin(admin);
        if(num>0){
            //添加成功
            map.addAttribute("message","ok");
        }else{
            //添加失败
            map.addAttribute("message","fail");
        }
    }

    @RequestMapping("deleteAdmin")
    @ResponseBody
    //删除管理员用户
    public void deleteAdmin(int id){
        int i = adminService.deleteAdmin(id);
    }


    @RequestMapping("updateAdmin")
    @ResponseBody
    //修改管理员信息
    public void updateAdmin(Administrator admin){
        //通过shiro框架加密密码
        String hashPassword = MD5Util.Md5Hash(admin.getAdPassword(), admin.getAdUsername());
        //将加密密码再次存入admin中。
        admin.setAdPassword(hashPassword);
        int num = adminService.updateAdminById(admin);
    }




}
