package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao {
    //查询全部存储物品信息
    List<Goods> queryAllGoods();

    //通过 登记人姓名和电话 查询存储物品信息
    List<Goods> queryGoodsByNameAndPhone(@Param("name") String goodsPerson, @Param("phone") String personPhone);

    //通过 登记人姓名和电话 查询存储物品信息
    List<Goods> queryGoodsByName(String goodsPerson);

    //根据 id 查询 个人存储信息
    Goods queryGoodsById(Integer goodsId);

    //修改 登记 信息（注：未实现 修改 存入和取出时间的修改）
    int updateById(Goods goods);

    //添加 物品信息
    int insertGoods(Goods goods);

    //删除 物品信息通过物品id
    int deleteById(int goodsId);
}
