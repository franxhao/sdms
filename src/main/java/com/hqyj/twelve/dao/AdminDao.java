package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Administrator;
import com.hqyj.twelve.pojo.Employee;

/**
 * @description:
 * @author: GP
 * @date: 2021/8/12-12:23
 */
public interface AdminDao {
    //添加一个管理员用户
    void insertAdmin(Administrator admin);
    //添加一个普通员工用户
    void insertEmployee(Employee employee);


}
