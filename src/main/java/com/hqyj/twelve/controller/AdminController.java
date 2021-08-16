package com.hqyj.twelve.controller;

import com.hqyj.twelve.pojo.Administrator;
import com.hqyj.twelve.pojo.Employee;
import com.hqyj.twelve.pojo.Outsider;
import com.hqyj.twelve.pojo.PageData;
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
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/list")
    //查询所有管理员用户
    public  String queryAllAdmin(ModelMap modelMap){
        List<Administrator> adminList = adminService.queryAllAdmin();
        modelMap.addAttribute("adminList",adminList);
        return "adminManagement";
    }

    @RequestMapping("/page")
    //通过分页返回管理员数据
    public String queryAllAdminByPage(Integer pageNumber, Integer pageSize, ModelMap modelMap ){
        int number;
        int size;
        if (pageNumber == null) {
            number = 1; //默认显示第一页
        } else {
            number = pageNumber;
        }
        if (pageSize == null) {
            size = 3;   //默认每页显示两条
        } else {
            size = pageSize;
        }
        PageData<Administrator> pageData = adminService.queryAllAdminByPage(number, size);
        modelMap.put("pageData", pageData);
        return "adminManagement";
    }

    @RequestMapping("/queryAdminById")
    @ResponseBody
    //通过id查询单个管理员用户（返回json数据）
    public  Administrator queryById(int id,ModelMap map){
        Administrator administrator = adminService.queryAdminById(id);
        return  administrator;
    }

    @RequestMapping("/queryEmpById")
    @ResponseBody
    //通过id查询单个管理员用户（返回json数据）
    public  Employee queryEmpById(int id,ModelMap map){
        Employee employee = adminService.queryEmpById(id);
        return  employee;
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

    @RequestMapping("/deleteAdmin")
    @ResponseBody
    //删除管理员用户
    public void deleteAdmin(int id){
        int i = adminService.deleteAdmin(id);
    }


    @RequestMapping("/updateAdmin")
    @ResponseBody
    //修改管理员信息
    public void updateAdmin(Administrator admin){
        //通过shiro框架加密密码
        String hashPassword = MD5Util.Md5Hash(admin.getAdPassword(), admin.getAdUsername());
        //将加密密码再次存入admin中。
        admin.setAdPassword(hashPassword);
        int num = adminService.updateAdminById(admin);
    }


    @RequestMapping("/listEmp")
    //查询所有普通员工
    public String listEmp(ModelMap modelMap){
        List<Employee> employees = adminService.queryAllEmp();
        modelMap.addAttribute("employees",employees);
        return "EmpManagement";
    }

    @RequestMapping("/deleteEmp")
    @ResponseBody
    //删除一个员工
    public  void deleteEmp(int id){
        int i = adminService.deleteEmp(id);
    }


     @RequestMapping("/addEmp")
     @ResponseBody
     //添加一个员工信息
     public void addEmp(Employee emp){
         ModelMap map=new ModelMap();
         //通过shiro框架加密密码
         String hashPassword = MD5Util.Md5Hash(emp.getEmpPassword(), emp.getEmpUsername());
         //将加密密码再次存入emp中。
         emp.setEmpPassword(hashPassword);
         int num = adminService.addEmp(emp);
         if(num>0){
             //添加成功
             map.addAttribute("message","ok");
         }else{
             //添加失败
             map.addAttribute("message","fail");
         }
     }

    @RequestMapping("/updateEmp")
    @ResponseBody
    //修改管理员信息
    public void updateEmp(Employee emp){
        //通过shiro框架加密密码
        String hashPassword = MD5Util.Md5Hash(emp.getEmpPassword(), emp.getEmpUsername());
        //将加密密码再次存入emp中。
        emp.setEmpPassword(hashPassword);
        int num = adminService.updateEmpById(emp);
    }


}
