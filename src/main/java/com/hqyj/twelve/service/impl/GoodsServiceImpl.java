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
        List<Goods> goods = goodsDao.queryAllGoods();
        return goods;
    }

    @Override
    public List<Goods> getGoodsByNameAndPhone(String goodsPerson, String personPhone) {
        List<Goods> goods = goodsDao.queryGoodsByNameAndPhone(goodsPerson, personPhone);
        return goods;
    }

    @Override
    public int modifyInformation(Goods goods) {
        int result = goodsDao.updateById(goods);
        return result;
    }

    @Override
    public int addGoods(Goods goods) {
        int result = goodsDao.insertGoods(goods);
        return result;
    }

    @Override
    public int removeById(int goodsId) {
        int result = goodsDao.deleteById(goodsId);
        return result;
    }
}
