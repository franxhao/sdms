package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Administrator;
import com.hqyj.twelve.pojo.Employee;

import java.util.List;

/**
 * @description:
 * @author: GP
 * @date: 2021/8/12-12:23
 */
public interface AdminDao {
    //添加一个管理员用户
    int  insertAdmin(Administrator admin);
    //添加一个普通员工用户
    int  insertEmployee(Employee employee);

    //查询所有管理员用户
    List<Administrator> queryAllAdmin();

    //查询所有普通用户
    List<Employee>   queryAllEmp();

    //根据用户名查询管理员
    Administrator queryAdminByUsername(String username);

    //根据用户名查询普通员工
    Employee queryEmpByUsername(String username);

    //根据用户名查询管理员
    Administrator queryAdminById(int id);

    //根据用户名模糊查询管理员
    List<Administrator> queryAdminByUsernameLike(String username);

    //根据用户名查询普通员工
    Employee queryEmpById(int id);

    //修改管理员信息(可以修改除了id的所有属性)
    int updateAdminById(Administrator admin);

    //修改普通员工用户信息(可以修改除了id的所有属性)
    int updateEmpById(Employee emp);

    //根据id修改普通用户密码
    int updateEmpPasswordById(Employee emp);

    //根据id修改管理员用户密码
    int  updateAdminPasswordById(Administrator admin);

    //根据id删除普通用户
    int deleteEmpById(Integer id);

    //根据id删除管理员用户
    int deleteAdminById(Integer id);




}
