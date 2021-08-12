package com.hqyj.twelve.service.impl;

import com.hqyj.twelve.dao.GoodsDao;
import com.hqyj.twelve.pojo.Goods;
import com.hqyj.twelve.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;


    @Override
    public List<Goods> getAllGoods() {
        System.out.println("全部存储物品信息");
        List<Goods> goods = goodsDao.queryAllGoods();
        return goods;
    }

    @Override
    public List<Goods> getGoodsByName(String goodsPerson, String personPhone) {
        System.out.println("通过登记人姓名和电话查询存储物品信息");
        List<Goods> goods = goodsDao.queryGoodsByNameAndPhone(goodsPerson, personPhone);
        return goods;
    }

    @Override
    public int modifyInformation(Goods goods) {
        System.out.println("修改登记信息");
        int result = goodsDao.updateInformation(goods);
        return result;
    }

    @Override
    public int addGoods(Goods goods) {
        int result = goodsDao.insertGoods(goods);
        return result;
    }
}
