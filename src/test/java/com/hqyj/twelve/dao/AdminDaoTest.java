package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Administrator;
import com.hqyj.twelve.pojo.Employee;
import com.hqyj.twelve.utils.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: GP
 * @date: 2021/8/12-14:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AdminDaoTest {

    @Autowired
    private AdminDao adminDao;

    //测试添加管理员用户
    @Test
    public void insertAdmin() {
        Administrator admin = new Administrator();
        admin.setAdUsername("豪桑");
        admin.setAdPassword("123456");
        admin.setAdName("梁豪");
        admin.setAdSex("男");
        admin.setAdAge(20);
        admin.setAdJob("管理员");
        admin.setAdPhone("12345678978");
        admin.setAdAddress("金牛区新诚信");
        admin.setRoleId(1);
        admin.setAdDes("没有描述");
        //通过shiro框架加密密码
        String hashPassword = MD5Util.Md5Hash(admin.getAdPassword(), admin.getAdUsername());
        //将加密密码再次存入admin中。
        admin.setAdPassword(hashPassword);
        adminDao.insertAdmin(admin);
    }

    //测试添加普通员工用户
    @Test
    public void insertEmployee() {
        Employee emp = new Employee();
        emp.setEmpUsername("阳桑");
        emp.setEmpPassword("123456");
        emp.setEmpName("阳东霖");
        emp.setEmpSex("男");
        emp.setEmpAge(22);
        emp.setEmpJob("宿管");
        emp.setEmpPhone("12345678974");
        emp.setEmpAddress("金牛区新诚信");
        emp.setRoleId(2);
        emp.setBuildId("1");
        emp.setEmpDes("没有描述");
        //通过shiro框架加密密码
        String hashPassword = MD5Util.Md5Hash(emp.getEmpPassword(), emp.getEmpUsername());
        //将加密密码再次存入emp中。
        emp.setEmpPassword(hashPassword);
        adminDao.insertEmployee(emp);
    }
}