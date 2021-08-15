package com.hqyj.twelve.controller;

import com.hqyj.twelve.pojo.Goods;
import com.hqyj.twelve.pojo.Outsider;
import com.hqyj.twelve.pojo.PageData;
import com.hqyj.twelve.service.GoodsService;
import com.hqyj.twelve.service.OutsiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/getAll")
    public String getAllOutsider(Integer pageNumber, Integer pageSize, ModelMap modelMap) {
        int number;
        int size;
        if (pageNumber == null) {
            number = 1; //默认显示第一页
        } else {
            number = pageNumber;
        }
        if (pageSize == null) {
            size = 3;   //默认每页显示两条
        } else {
            size = pageSize;
        }
        PageData<Goods> pageData = goodsService.getGoodsByPage(number, size);
        modelMap.put("pageData", pageData);
        return "goods";
    }

    @RequestMapping("/addGoods")
    @ResponseBody
    public Map<String, Object> addGoods(@RequestBody Goods goods) {
        goodsService.addGoods(goods);
        Map<String, Object> map = new HashMap<>();
        map.put("message", "添加成功");
        return map;
    }

    @RequestMapping("/updateGoods")
    @ResponseBody
    public Map<String, Object> updateOutsider(@RequestBody Goods goods) {
        Integer goodsId = goods.getGoodsId();
        Goods goodsById = goodsService.getGoodsById(goodsId);
        Map<String, Object> map = new HashMap<>();
        map.put("goods", goodsById);
        return map;
    }

    @RequestMapping("/updateGoodsDo")
    @ResponseBody
    public Map<String,Object> updateOutsiderDo(@RequestBody Goods goods){
        System.out.println(goods);
        int result = goodsService.modifyInformation(goods);
        System.out.println(result);
        Map<String,Object> map = new HashMap<>();
        map.put("message","修改成功");
        return map;
    }

    @RequestMapping("/deleteOne")
    @ResponseBody
    public Map<String, Object> deleteOne(@RequestBody Goods goods) {
        goodsService.removeById(goods.getGoodsId());
        Map<String, Object> map = new HashMap<>();
        map.put("message", "删除成功");
        return map;
    }
}
