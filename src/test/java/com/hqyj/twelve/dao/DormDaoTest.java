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
        Dorm dorm = new Dorm(6,"女",1000,4,10,null);
        int rs = dormDao.updateOne(dorm);
        System.out.println("返回结果："+rs);
    }
    @Test
    public void insertOne() {
        Dorm dorm = new Dorm(0,"女",100,4,10,null);
        int rs = dormDao.insertOne(dorm);
        System.out.println("返回结果："+rs);
    }
    @Test
    public void deleteById(){
        int rs = dormDao.deleteById(5);
        System.out.println("返回结果："+rs);
    }
    @Test
        //按id查阅一个寝室
    public void queryDormById(){
        Dorm dorm = dormDao.queryDormById(2);
        System.out.println(dorm);
    }
}