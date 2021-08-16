package com.hqyj.twelve.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.twelve.dao.DormDao;
import com.hqyj.twelve.pojo.Building;
import com.hqyj.twelve.pojo.Dorm;
import com.hqyj.twelve.pojo.PageData;
import com.hqyj.twelve.service.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class DormServiceImpl implements DormService {
    @Autowired
    private DormDao dormDao;
    @Override
    public List<Dorm> queryAll() {
        return dormDao.queryAll();
    }

    @Override
    public int updateOne(Dorm dorm) {
        return dormDao.updateOne(dorm);
    }

    @Override
    public int insertOne(Dorm drom) {
        return dormDao.insertOne(drom);
    }

    @Override
    public int deleteById(int dorId) {
        return dormDao.deleteById(dorId);
    }

    @Override
    public PageData<Dorm> getDormByPage(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Dorm> dormList = dormDao.queryAll();
        PageInfo<Dorm> pageInfo = new PageInfo<>(dormList);
        PageData<Dorm> pageData = new PageData<>();

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
