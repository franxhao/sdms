package com.hqyj.twelve.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.twelve.dao.OutSiderDao;
import com.hqyj.twelve.pojo.Outsider;
import com.hqyj.twelve.pojo.PageData;
import com.hqyj.twelve.service.OutsiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutsiderServiceImpl implements OutsiderService {
    @Autowired
    private OutSiderDao outSiderDao;

    @Override
    public List<Outsider> getAllOutsider() {
        List<Outsider> outsiders = outSiderDao.queryAllOutsider();
        return outsiders;
    }

    @Override
    public List<Outsider> getGoodsByNameAndPhone(String outName, String outPhone) {
        List<Outsider> outsiders = outSiderDao.queryOutsiderByNameAndPhone(outName, outPhone);
        return outsiders;
    }

    @Override
    public int addOutsider(Outsider outsider) {
        int result = outSiderDao.insertOutsider(outsider);
        return result;
    }

    @Override
    public PageData<Outsider> getOutsiderByPage(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Outsider> outsider = outSiderDao.queryAllOutsider();
        PageInfo<Outsider> pageInfo = new PageInfo<>(outsider);
        PageData<Outsider> pageData = new PageData<>();

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
