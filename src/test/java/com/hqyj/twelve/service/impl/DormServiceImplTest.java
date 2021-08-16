package com.hqyj.twelve.service.impl;

import com.hqyj.twelve.pojo.Dorm;
import com.hqyj.twelve.service.DormService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class DormServiceImplTest {
    @Autowired
    private DormService dormService;
    @Test
    public void queryAll() {
        List<Dorm> dormList = dormService.queryAll();
        for (Dorm dorms:dormList){
            System.out.println(dorms);
        }
    }

}