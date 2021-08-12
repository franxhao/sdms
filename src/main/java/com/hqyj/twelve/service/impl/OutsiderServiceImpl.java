package com.hqyj.twelve.service.impl;

import com.hqyj.twelve.dao.OutSiderDao;
import com.hqyj.twelve.pojo.Outsider;
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
}
