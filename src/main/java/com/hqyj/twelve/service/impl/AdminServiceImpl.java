package com.hqyj.twelve.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.twelve.dao.AdminDao;
import com.hqyj.twelve.pojo.Administrator;
import com.hqyj.twelve.pojo.Employee;
import com.hqyj.twelve.pojo.PageData;
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

    @Override
    public Employee queryEmpById(int id) {
        return adminDao.queryEmpById(id);
    }

    @Override
    public int addEmp(Employee emp) {
        int i = adminDao.insertEmployee(emp);
        return i ;
    }

    @Override
    public int deleteEmp(int id) {
        return adminDao.deleteEmpById(id);
    }

    @Override
    public int updateEmpById(Employee emp) {
        return adminDao.updateEmpById(emp);
    }

    @Override
    public Administrator queryAdminByUsername(String username) {
        return adminDao.queryAdminByUsername(username);
    }

    @Override
    public Employee queryEmpByUsername(String username) {
        return adminDao.queryEmpByUsername(username);
    }

    @Override
    public PageData<Administrator> queryAllAdminByPage(Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Administrator> Administrator = adminDao.queryAllAdmin();
        PageInfo<Administrator> pageInfo = new PageInfo<>(Administrator);
        PageData<Administrator> pageData = new PageData<>();

        pageData.setCurrentPage(pageNumber);
        pageData.setPageSize(pageSize);
        pageData.setTotalPage(pageInfo.getPages());
        pageData.setTotalSize((int) pageInfo.getTotal());
        if (pageInfo.isHasNextPage()) {
            pageData.setNextPage(pageInfo.getNextPage());
        } else {
            pageData.setNextPage(pageInfo.getPages());
        }
        if (pageInfo.isHasPreviousPage()) {
            pageData.setPreviousPage(pageInfo.getPrePage());
        } else {
            pageData.setPreviousPage(1);
        }
        pageData.setList(pageInfo.getList());
        return pageData;
    }

    @Override
    public List<Administrator> queryAdminByUsernameLike(String username) {
        return adminDao.queryAdminByUsernameLike("%"+username+"%");
    }
}
