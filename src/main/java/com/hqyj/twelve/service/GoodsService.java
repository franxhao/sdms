package com.hqyj.twelve.service;

import com.hqyj.twelve.pojo.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GoodsService {
    //查询全部存储物品信息
    List<Goods> getAllGoods();

    //通过 登记人姓名和电话 查询存储物品信息
    List<Goods> getGoodsByName(String goodsPerson,String personPhone);

    //修改 登记 信息
    int modifyInformation(Goods goods);
}
