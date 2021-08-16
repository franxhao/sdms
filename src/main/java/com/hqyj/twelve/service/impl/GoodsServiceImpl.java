package com.hqyj.twelve.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.twelve.dao.GoodsDao;
import com.hqyj.twelve.pojo.Goods;
import com.hqyj.twelve.pojo.Outsider;
import com.hqyj.twelve.pojo.PageData;
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
    public List<Goods> getGoodsByName(String goodsPerson) {
        List<Goods> goods = goodsDao.queryGoodsByName(goodsPerson);
        return goods;
    }

    @Override
    public Goods getGoodsById(Integer goodsId) {
        Goods goods = goodsDao.queryGoodsById(goodsId);
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

    @Override
    public PageData<Goods> getGoodsByPage(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Goods> goods = goodsDao.queryAllGoods();
        PageInfo<Goods> pageInfo = new PageInfo<>(goods);
        PageData<Goods> pageData = new PageData<>();

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
