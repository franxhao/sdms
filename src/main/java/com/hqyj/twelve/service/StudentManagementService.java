package com.hqyj.twelve.service;

import com.hqyj.twelve.pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentManagementService {
    /**
     * 查所有学生信息
     * @return
     */
    List<Student> findAll();

    /**
     * 添加学生信息，只做学生添加，加入成功后入住状态默认为未入住
     * @param data
     * @return
     */
    String addStu(Map<String, Object> data);
}
