package com.hqyj.twelve.service;

import com.hqyj.twelve.pojo.Administrator;
import com.hqyj.twelve.pojo.Employee;
import com.hqyj.twelve.pojo.PageData;

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

    //通过id查询指定的员工用户
    Employee queryEmpById(int id);


    //通过管理员用户名查询
    Administrator queryAdminByUsername(String username);

    //通过普通员工用户名查询
    Employee queryEmpByUsername(String username);


    //添加一个管理员用户
    int  addAdmin(Administrator admin);

    //删除一个管理员用户
    int deleteAdmin(int id);

    //修改管理员用户信息
    int updateAdminById(Administrator admin);

    //添加一个员工用户
    int addEmp(Employee emp);

    //删除一个员工用户
    int deleteEmp(int id);

    //修改员工用户信息
    int updateEmpById(Employee emp);

    //通过分页返回管理员数据
    PageData<Administrator> queryAllAdminByPage(Integer pageNumber, Integer pageSize);

}
