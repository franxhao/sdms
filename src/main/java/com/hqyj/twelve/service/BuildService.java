package com.hqyj.twelve.service;

import com.hqyj.twelve.pojo.Building;
import com.hqyj.twelve.pojo.Outsider;
import com.hqyj.twelve.pojo.PageData;

import java.util.List;
import java.util.Map;

public interface BuildService {
    //查询楼房信息
    List<Building> queryAll();
    //修改楼房信息
    int updateOne(Building building);
    //添加楼房
    int insertOne(Building building);
    //删除
    int deleteById(Integer buildId);
    //分页查询楼房信息
    //pageNumber 页码     pageSize 每页记录数
    PageData<Building> getBuildByPage(int pageNumber, int pageSize);
    //按id查询一个
    //根据 id 查询 楼房信息
    Map<String ,Object> queryBuildById(Integer buildId);
}
