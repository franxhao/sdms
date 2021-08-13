package com.hqyj.twelve.service;

import com.hqyj.twelve.pojo.Administrator;
import com.hqyj.twelve.pojo.Employee;

import java.util.List;

/**
 * @description:
 * @author: GP
 * @date: 2021/8/12-18:57
 */
public interface AdminService {

    //查询所有管理员用户
    List<Administrator> queryAllAdmin();

    //通过id查询指定的管理员用户
    Administrator queryAdminById(int id);

    //查询所有普通用户
    List<Employee> queryAllEmp();

    //添加一个管理员用户
    int  addAdmin(Administrator admin);

    //删除一个管理员用户
    int deleteAdmin(int id);

    //修改管理员用户信息
    int updateAdminById(Administrator admin);
}
