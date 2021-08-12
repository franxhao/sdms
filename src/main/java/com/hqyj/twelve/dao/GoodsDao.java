package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao {
    //查询全部存储物品信息
    List<Goods> queryAllGoods();

    //通过 登记人姓名和电话 查询存储物品信息
    List<Goods> queryGoodsByName(@Param("name") String goodsPerson, @Param("phone") String personPhone);

    //修改 登记 信息（注：未实现 修改 存入和取出时间的修改）
    int updateInformation(Goods goods);
}
