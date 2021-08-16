package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Building;
import com.hqyj.twelve.pojo.Dorm;
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
     * 通过学号和姓名查询学生
     * @param stuKey
     * @param stuName
     * @return
     */
    Student queryStuByKeyAndName(@Param("stuKey") String stuKey, @Param("stuName") String stuName);

    /**
     * 更新学生信息
     * @param editMassage
     * @return
     */
    boolean UpdateStuMassage(Map<String, Object> editMassage);

    /**
     * 通过学生学号和姓名删除学生信息(未入住学生适用)
     * @param stuKey
     * @param stuName
     * @return
     */
    int deleteOneByKeyAndName(@Param("stuKey") String stuKey, @Param("stuName") String stuName);

    /**
     * 通过学生id查询学生寝室表
     * @param stuId
     * @return
     */
    int queryStuDorByStuId(Integer stuId);

    /**
     * 通学生寝室表通过id删除记录
     * @param id
     */
    void deleteStuDorById(Integer id);

    /**
     * 通过寝室id查询寝室信息
     * @param dorId
     * @return
     */
    Dorm queryDormById(Integer dorId);

    /**
     * 通过id删除学生
     * @param stuId
     * @return
     */
    int deleteOneById(Integer stuId);


}
