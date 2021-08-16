package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: GP
 * @date: 2021/8/16-10:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class RoleDaoTest {

    @Autowired
    private RoleDao roleDao;



    @Test
    public void queryRoleById() {
        Role role = roleDao.queryRoleById(1);
        System.out.println(role.getRoleName());
    }
}