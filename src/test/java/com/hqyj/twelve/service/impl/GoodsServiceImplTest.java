package com.hqyj.twelve.service.impl;

import com.hqyj.twelve.pojo.Goods;
import com.hqyj.twelve.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.sql.DatabaseMetaData;
import java.util.Date;
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
    public void getGoodsByNameAndPhoneTest() {
        List<Goods> goodsByName = goodsService.getGoodsByNameAndPhone("张三", "16698422685");
        for (Goods goods : goodsByName) {
            System.out.println(goods);
        }
    }

    @Test
    public void getGoodsByName() {
        List<Goods> goodsByName = goodsService.getGoodsByName("张小三");
        for (Goods goods : goodsByName) {
            System.out.println(goods);
        }
    }

    @Test
    public void getGoodsByIdTest(){
        Goods goodsById = goodsService.getGoodsById(1);
        System.out.println(goodsById);
    }

    @Test
    public void modifyInformationTest() {
        Goods goods = new Goods();
        goods.setGoodsId(2);
        goods.setGoodsPerson("张麻子");
        goods.setPersonPhone("16698422685");
        goods.setGoodsName("书包");
        //goods.setGoodsOut("2021-7-15");
        int result = goodsService.modifyInformation(goods);
        if (result > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    @Test
    public void addGoodsTest() {
        Goods goods = new Goods();
        goods.setGoodsName("零食");
        goods.setGoodsPerson("王五");
        goods.setPersonPhone("14914687136");
        goods.setGoodsIn(new Date());
        goods.setGoodsDes("存五天");
        int result = goodsService.addGoods(goods);
        if (result > 0) {
            System.out.println("储存成功");
        } else {
            System.out.println("储存失败");
        }
    }

    @Test
    public void removeByIdTest() {
        int result = goodsService.removeById(5);
        if (result > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }
}