package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Dorm;

import java.util.List;

public interface DormDao {
    //查询寝室信息
    List<Dorm>queryAll();
    //修改寝室信息
    int updateOne(Dorm dorm);
}
