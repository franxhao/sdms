package com.hqyj.twelve.service;

import com.hqyj.twelve.pojo.Building;
import com.hqyj.twelve.pojo.Dorm;
import com.hqyj.twelve.pojo.PageData;

import java.util.List;

public interface DormService {
    //查询寝室信息
    List<Dorm> queryAll();
    //修改寝室信息
    int updateOne(Dorm dorm);
    //增加寝室信息
    int insertOne(Dorm drom);
    //删除寝室
    int deleteById(int dorId);
    //分页查询寝室信息
    //pageNumber 页码     pageSize 每页记录数
    PageData<Dorm> getDormByPage(int pageNumber, int pageSize);
}
