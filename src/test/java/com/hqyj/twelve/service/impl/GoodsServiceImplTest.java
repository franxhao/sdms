package com.hqyj.twelve.service.impl;

import com.hqyj.twelve.pojo.Goods;
import com.hqyj.twelve.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class GoodsServiceImplTest {
    @Autowired
    private GoodsService goodsService;

    @Test
    public void getAllGoodsTest() {
        List<Goods> allGoods = goodsService.getAllGoods();
        for (Goods allGood : allGoods) {
            System.out.println(allGood);
        }
    }

    @Test
    public void getGoodsByNameTest() {
        List<Goods> goodsByName = goodsService.getGoodsByName("张三", "16698422568");
        for (Goods goods : goodsByName) {
            System.out.println(goods);
        }
    }

    @Test
    public void modifyInformationTest() {
        Goods goods = new Goods();
        goods.setGoodsId(2);
        goods.setGoodsName("背包");
        //goods.setGoodsOut("2021-7-15");
        goods.setGoodsDes("希望继续存放四天");
        int result = goodsService.modifyInformation(goods);
        if(result>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }
}