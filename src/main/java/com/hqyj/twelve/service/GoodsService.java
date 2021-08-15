package com.hqyj.twelve.service;

import com.hqyj.twelve.pojo.Goods;
import com.hqyj.twelve.pojo.Outsider;
import com.hqyj.twelve.pojo.PageData;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GoodsService {
    //查询全部存储物品信息
    List<Goods> getAllGoods();

    //通过 登记人姓名和电话 查询存储物品信息
    List<Goods> getGoodsByNameAndPhone(String goodsPerson, String personPhone);

    //根据 id 查询 个人存储信息
    Goods getGoodsById(Integer goodsId);

    //修改 登记 信息
    int modifyInformation(Goods goods);

    //添加 存储物品信息
    int addGoods(Goods goods);

    //删除 存储物品信息
    int removeById(int goodsId);

    //获取单页的用户信息
    //pageNumber 页码     pageSize 每页记录数
    PageData<Goods> getGoodsByPage(int pageNumber, int pageSize);
}
