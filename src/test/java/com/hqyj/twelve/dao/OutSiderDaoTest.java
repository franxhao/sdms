package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Outsider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class OutSiderDaoTest {
    @Autowired
    private OutSiderDao outSiderDao;
    @Test
    public void queryOutsiderById() {
        Outsider outsider = outSiderDao.queryOutsiderById(2);
        System.out.println(outsider);
    }
}