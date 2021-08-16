package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Building;
import com.hqyj.twelve.pojo.Outsider;

import java.util.List;

public interface BuildDao {
    //查询楼房信息
    List<Building> queryAll();
    //修改楼房信息
    int updateOne(Building building);
    //添加楼房
    int insertOne(Building building);
    //删除
    int deleteById(int buildId);
    //按id查询一个
    //根据 id 查询 楼房信息
    Building queryBuildById(int buildId);
}
