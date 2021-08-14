package com.hqyj.twelve.service.impl;

import com.hqyj.twelve.pojo.Administrator;
import com.hqyj.twelve.pojo.Employee;
import com.hqyj.twelve.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: GP
 * @date: 2021/8/12-19:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class AdminServiceImplTest {
    @Autowired
    private AdminService adminService;

    @Test
    public void queryAllAdmin() {
        List<Administrator> administrators = adminService.queryAllAdmin();
        System.out.println(administrators);
    }

    @Test
    public void queryAllEmp(){
        List<Employee> employees = adminService.queryAllEmp();
        System.out.println(employees);
    }

}