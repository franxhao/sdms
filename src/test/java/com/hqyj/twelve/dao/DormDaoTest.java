package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Dorm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class DormDaoTest {
@Autowired
private DormDao dormDao;
    @Test
    public void queryAll() {
        List<Dorm> dormList = dormDao.queryAll();
        for (Dorm dorms:dormList){
            System.out.println(dorms);
        }
    }

    @Test
    public void updateOne() {
    }
}