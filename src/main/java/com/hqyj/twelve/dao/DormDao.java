package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Building;
import com.hqyj.twelve.pojo.Dorm;

import javax.swing.*;
import java.sql.Driver;
import java.util.List;
import java.util.Map;

public interface DormDao {
    //查询寝室信息
    List<Dorm>queryAll();
    //修改寝室信息
    int updateOne(Dorm dorm);
    //增加寝室信息
    int insertOne(Dorm dorm);
    //删除寝室
    int deleteById(Integer dorId);
    //按id查阅一个寝室
    Map<String, Object> queryDormById(Integer dormId);
}
