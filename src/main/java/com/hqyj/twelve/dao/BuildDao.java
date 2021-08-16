package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Building;

import java.util.List;
import java.util.Map;

public interface BuildDao {
    //查询楼房信息
    List<Building> queryAll();
    //修改楼房信息
    int updateOne(Building building);
    //添加楼房
    int insertOne(Building building);
    //删除
    int deleteById(int buildId);

}
