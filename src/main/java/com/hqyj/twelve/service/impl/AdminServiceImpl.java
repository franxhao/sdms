package com.hqyj.twelve.service.impl;

import com.hqyj.twelve.dao.AdminDao;
import com.hqyj.twelve.pojo.Administrator;
import com.hqyj.twelve.pojo.Employee;
import com.hqyj.twelve.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: GP
 * @date: 2021/8/12-18:57
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;


    @Override
    public List<Administrator> queryAllAdmin() {
        return adminDao.queryAllAdmin();
    }

    @Override
    public List<Employee> queryAllEmp() {
        return adminDao.queryAllEmp();
    }

    @Override
    public int addAdmin(Administrator admin) {
        int num = adminDao.insertAdmin(admin);
        return num;
    }

    @Override
    public int deleteAdmin(int id) {
        return adminDao.deleteAdminById(id);
    }

    @Override
    public Administrator queryAdminById(int id) {
        return adminDao.queryAdminById(id);
    }

    @Override
    public int updateAdminById(Administrator admin) {
        return adminDao.updateAdminById(admin);
    }
}
