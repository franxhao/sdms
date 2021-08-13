package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Employee;

import java.util.List;

public interface EmployeeDao {
    //查询员工表
    List<Employee> queryAll();
    //修改员工表信息
    int updateOne(Employee employee);
    //添加一个员工
    int insertOne(Employee employee);
    //删除一个员工
    int deleteById(int empId);
}
