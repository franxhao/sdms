package com.hqyj.twelve.service.impl;

import com.hqyj.twelve.dao.BuildDao;
import com.hqyj.twelve.dao.DormDao;
import com.hqyj.twelve.dao.StudentDao;
import com.hqyj.twelve.pojo.Building;
import com.hqyj.twelve.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class StudentManagementServiceImplTest {
    @Autowired
    public StudentManagementServiceImpl studentManagementService;

    @Autowired
    public StudentDao studentDao;

    @Autowired
    public DormDao dormDao;

    @Autowired
    public BuildDao buildDao;

    @Test
    public void findAll() {

    }

    @Test
    public void removeByKeyAndName() {
        Student student = studentDao.queryStuByKeyAndName("20180105", "李四");
        System.out.println(student.getStuId());
        System.out.println(student.getStuState());
    }
}