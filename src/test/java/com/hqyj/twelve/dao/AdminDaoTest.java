package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Administrator;
import com.hqyj.twelve.pojo.Employee;
import com.hqyj.twelve.utils.MD5Util;
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
        admin.setAdUsername("谢桑");
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
        emp.setEmpUsername("瑶桑");
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

    @Test
    public void queryAllAdmin(){
        List<Administrator> administrators = adminDao.queryAllAdmin();
        System.out.println(administrators);
    }

    @Test
    public void queryAllEmp(){
        List<Employee> employees = adminDao.queryAllEmp();
        System.out.println(employees);
    }

    @Test
    public void updateEmpPassword(){
        Employee emp = new Employee();
        emp.setEmpId(1);
        //通过shiro框架加密密码
        String hashPassword = MD5Util.Md5Hash("123456", "豪桑");
        //将加密密码再次存入emp中。
        emp.setEmpPassword(hashPassword);

        adminDao.updateEmpPasswordById(emp);

    }

    @Test
    public void updateAdminPassword(){
        Administrator admin = new Administrator();
        admin.setAdId(3);
        //通过shiro框架加密密码
        String hashPassword = MD5Util.Md5Hash("123456", "豪桑");
        //将加密密码再次存入emp中。
        admin.setAdPassword(hashPassword);
        adminDao.updateAdminPasswordById(admin);
    }



    @Test
    public void deleteEmpById(){
        int num = adminDao.deleteEmpById(2);
        System.out.println(num);
    }

    @Test
    public void deleteAdminById(){
        int i = adminDao.deleteAdminById(2);
        System.out.println(i);
    }

    @Test
    public void queryAdminByUsername(){
        Administrator administrator = adminDao.queryAdminByUsername("梁%");
        System.out.println(administrator);
    }

    @Test
    public void queryEmpByUsername(){
        Employee employee = adminDao.queryEmpByUsername("阳%");
        System.out.println(employee);
    }

    @Test
    public void queryAdminById(){
        Administrator administrator = adminDao.queryAdminById(1);
        System.out.println(administrator);
    }

    @Test
    public void updateAdminByid(){
        Administrator administrator = adminDao.queryAdminById(20);
        administrator.setAdUsername("梁桑花");
        adminDao.updateAdminById(administrator);
    }
}