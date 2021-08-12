package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class EmployeeDaoTest {
@Autowired
private EmployeeDao employeeDao;
@Test
public void queryAll(){
    List<Employee> employeeList = employeeDao.queryAll();
    for(Employee employees:employeeList){
        System.out.println(employees);
    }
}
    @Test
    public void updateOne() {
        Employee employee2 = new Employee(2,"wangliu","123456","王六","女",
                35,"宿管","13454545","重庆璧山",1,"2","无");
        int rs = employeeDao.updateOne(employee2);
        System.out.println("返回结果："+rs);
    }

    @Test
    public void insertOne() {
        Employee employee1 = new Employee(0,"wangliu","123456","王六","女",
                30,"宿管","13333333","重庆璧山",1,"1","无");
        int rs = employeeDao.insertOne(employee1);
        System.out.println("返回结果："+rs);
    }

    @Test
    public void deleteById() {
        int rs = employeeDao.deleteById(4);
        System.out.println("返回的结果："+rs);
    }
}