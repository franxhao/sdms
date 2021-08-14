package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 学生信息
 */
public interface StudentDao {
    /**
     * 获取所有学生的信息（含未分配入住）
     */
    List<Student> findAll();

    /**
     * 数据库添加学生信息
     * @param data
     */
    boolean addStu(Map<String, Object> data);

    /**
     * 查询对应性别寝室状态
     * @param stuSex 分配入住性别楼
     * @return 返回应住人数和实住人数
     */
    List<Integer> queryRoomState(String stuSex);

    /**
     * 通过学号和姓名查询学生
     * @param stuKey
     * @param stuName
     * @return
     */
    Map<String, Object> queryStuByKeyAndName(@Param("stuKey") String stuKey, @Param("stuName") String stuName);

    /**
     * 在学生寝室表中添加数据
     * @param stuId
     * @param stuSex
     */
    void addStuIdToAD(@Param("stuId") Integer stuId, @Param("stuSex") String stuSex);
}
