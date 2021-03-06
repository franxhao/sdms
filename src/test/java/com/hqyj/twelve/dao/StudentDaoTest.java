package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class StudentDaoTest {

    @Autowired
    public StudentDao studentDao;

    @Test
    public void findAll() {
        List<Student> list = studentDao.findAll();
        list.forEach(s -> System.out.println(s));
    }

    @Test
    public void queryStuByKeyAndName() {
        String stuKey = "20180101";
        String stuName = "阳神";
        Student stu = studentDao.queryStuByKeyAndName(stuKey, stuName);
        System.out.println(stu);
        if (stu == null) {
            System.out.println("查无此人");
        } else {
            System.out.println("此人存在");
        }
    }

    @Test
    public void addStu() {
        Map<String, Object> map = new HashMap<>();
        String stuKey = "20001";
        String stuName = "zs";
        map.put("stuKey", stuKey);
        map.put("stuName", stuName);
        //boolean b = studentDao.addStu(map);
        boolean result = studentDao.addStu(map);
        System.out.println(result);
        System.out.println(map.get("stuId"));
    }

    @Test
    public void addStuIdToAD() {
        Integer stuId = 17;
        String stuSex = "男";
//        studentDao.addStuIdToAD(stuId,stuSex);
    }


    @Test
    public void testQueryStuByKeyAndName() throws ParseException {
        String stuKey = "20190102";
        String stuName = "阳神1";
        studentDao.queryStuByKeyAndName(stuKey, stuName);
//        System.out.println(stu);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

//        stu.forEach(s-> System.out.println(simpleDateFormat.format(s.getStuBirth())));
    }

    @Test
    public void queryStuDorByStuId() {
        System.out.println(studentDao.queryStuDorByStuId(4));
    }


}