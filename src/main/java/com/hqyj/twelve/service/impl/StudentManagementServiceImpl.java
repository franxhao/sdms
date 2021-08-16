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
        } catch (Exception e) {
            e.printStackTrace();
        }

        //2.添加学生信息
            //2.1通过查询学生学号和姓名，判断该学生是否已经在库中，不在则添加，在则不添加
        String stuKey = (String) data.get("stuKey");
        String stuName = (String) data.get("stuName");
        List<Student> student = studentDao.queryStuByKeyAndName(stuKey, stuName);
        if (student.size() == 0) {
            //无此学生，可以添加
            boolean result = studentDao.addStu(data);
            if (result) {
                //3.添加成功,向学生寝室表中添加记录
                //3.1 获取学生性别后做记录添加
                Integer stuId= (Integer) data.get("stuId");
                String stuSex = (String) data.get("stuSex");
                studentDao.addStuIdToAD(stuId,stuSex);
                // 返回ok，表示添加成功
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

    @Override
    public void searchVal(Map<String, Object> map) {
        //1.获取用户所选的搜索条件
        String[] sel = (String[]) map.get("sel");
        for (int i = 0; i < sel.length; i++) {
            if (sel[i].equals("sel1")) {
                String op1 = "sel1";
            } else if (sel[i].equals("sel2")) {
                String op2 = "sel2";
            } else if (sel[i].equals("sel3")) {
                String op3 = "sel3";
            } else if (sel[i].equals("sel4")) {
                String op4 = "sel4";
            } else if (sel[i].equals("sel5")) {
                String op5 = "sel5";
            }
        }
        //2.获取用户搜索框输入的值
        String search = (String) map.get("search_val");
        //3.调用DAO层方法，做模糊查询
        //studentDao.searchSth();
        //4.返回学生类型
    }

    @Override
    public List<Student> reEditMessage(Map<String, Object> keyAndName) {
        //获取学号和姓名
        String stuKey = (String) keyAndName.get("key");
        String stuName = (String) keyAndName.get("name");

        //通过学号和姓名查询学生信息
        List<Student> student = studentDao.queryStuByKeyAndName(stuKey, stuName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (Student stu : student) {
            String enr = simpleDateFormat.format(stu.getStuEnr());
            String birth = simpleDateFormat.format(stu.getStuBirth());

            //Date parse = simpleDateFormat.parse(enr);
            //stu.setStuEnr(stuEnr);
        }

        //将学生信息返回给控制器
        return student;
    }

    @Override
    public String stuEdit(Map<String, Object> editMassage) {
        boolean flag = studentDao.UpdateStuMassage(editMassage);
        if (flag) {
            //修改成功，返回ok
            return "ok";
        }else {
            //修改失败，返回fail
            return "fail";
        }
    }
}
