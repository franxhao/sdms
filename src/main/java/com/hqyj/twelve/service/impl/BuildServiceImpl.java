package com.hqyj.twelve.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.twelve.dao.BuildDao;
import com.hqyj.twelve.pojo.Building;
import com.hqyj.twelve.pojo.Outsider;
import com.hqyj.twelve.pojo.PageData;
import com.hqyj.twelve.service.BuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BuildServiceImpl implements BuildService {
    @Autowired
    private BuildDao buildDao;
    @Override
    public List<Building> queryAll() {
        return  buildDao.queryAll();
    }

    @Override
    public int updateOne(Building building) {
        return buildDao.updateOne(building);
    }

    @Override
    public int insertOne(Building building) {
        return buildDao.insertOne(building);
    }

    @Override
    public int deleteById(int buildId) {
        return buildDao.deleteById(buildId);
    }

    @Override
    public PageData<Building> getBuildByPage(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Building> buildingList = buildDao.queryAll();
        PageInfo<Building> pageInfo = new PageInfo<>(buildingList);
        PageData<Building> pageData = new PageData<>();

        pageData.setCurrentPage(pageNumber);
        pageData.setPageSize(pageSize);
        pageData.setTotalPage(pageInfo.getPages());
        pageData.setTotalSize((int) pageInfo.getTotal());
        if (pageInfo.isHasNextPage()) {
            pageData.setNextPage(pageInfo.getNextPage());
        } else {
            pageData.setNextPage(pageInfo.getPages());
        }
        if (pageInfo.isHasPreviousPage()) {
            pageData.setPreviousPage(pageInfo.getPrePage());
        } else {
            pageData.setPreviousPage(1);
        }
        pageData.setList(pageInfo.getList());
        return pageData;
    }
}
