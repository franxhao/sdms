package com.hqyj.twelve.service.impl;

import com.hqyj.twelve.dao.StudentDao;
import com.hqyj.twelve.pojo.Student;
import com.hqyj.twelve.service.StudentManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class StudentManagementServiceImpl implements StudentManagementService {
    @Autowired
    public StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public String addStu(Map<String, Object> data) {
        //1.将入学日期和出生日期的字符串类型转换为时间格式
        //stuEnr:$("#stuEnr").val()
        //stuBirthday:$("#stuBirthday").val()
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date enr = simpleDateFormat.parse((String) data.get("stuEnr"));
            Date birthday = simpleDateFormat.parse((String) data.get("stuBirth"));
            data.put("stuEnr",enr);
            data.put("stuBirth",birthday);
            studentDao.addStu(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //2.添加学生信息
            //2.1通过查询学生学号和姓名，判断该学生是否已经在库中，不在则添加，在则不添加
        String stuKey = (String) data.get("stuKey");
        String stuName = (String) data.get("stuName");
        Map<String, Object> map = studentDao.queryStuByKeyAndName(stuKey, stuName);
        if (map == null) {
            //无此学生，可以添加
            boolean b = studentDao.addStu(data);
            if (b) {
                //添加成功,返回ok，表是添加成功
                return "ok";
            } else {
                //添加失败，返回fail,表示添加失败
                return "fail";
            }
        } else {
            //有此学生，返回exist，表示已存在
            return "exist";
        }
    }
}
