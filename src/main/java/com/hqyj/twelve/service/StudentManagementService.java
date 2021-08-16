package com.hqyj.twelve.service;

import com.github.pagehelper.Page;
import com.hqyj.twelve.pojo.PageData;
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

    /**
     * 搜索功能
     * @param map
     */
    void searchVal(Map<String, Object> map);

    /**
     * 修改学生信息之回传数据
     * @param keyAndName
     * @return
     */
    Student reEditMessage(Map<String, Object> keyAndName);

    /**
     * 修改学生信息
     * @param editMassage
     * @return
     */
    String stuEdit(Map<String, Object> editMassage);

    /**
     * 分页功能
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageData<Student> getStuManagementByPage(int pageNumber, int pageSize);

    /**
     * 通过学号和姓名删除学生
     * @param keyName
     * @return
     */
    int removeByKeyAndName(Map<String, Object> keyName);

    /**
     * 通过studentPOJO类添加学生
     * @param student
     */
    void addStuforStudent(Student student);
}
