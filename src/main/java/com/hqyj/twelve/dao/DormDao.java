package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Dorm;

import javax.swing.*;
import java.sql.Driver;
import java.util.List;

public interface DormDao {
    //查询寝室信息
    List<Dorm>queryAll();
    //修改寝室信息
    int updateOne(Dorm dorm);
    //增加寝室信息
    int insertOne(Dorm drom);
    //删除寝室
    int deleteById(int dorId);
}
