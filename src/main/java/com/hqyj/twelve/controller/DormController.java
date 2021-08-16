package com.hqyj.twelve.controller;

import com.hqyj.twelve.pojo.Building;
import com.hqyj.twelve.pojo.Dorm;
import com.hqyj.twelve.pojo.Outsider;
import com.hqyj.twelve.pojo.PageData;
import com.hqyj.twelve.service.BuildService;
import com.hqyj.twelve.service.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dorm")
public class DormController {
    @Autowired
    private DormService dormService;
    @RequestMapping("/queryAllDorm")
    public String queryAllBuilding(ModelMap modelMap){
        List<Dorm> dormList = dormService.queryAll();
        modelMap.addAttribute("dormList",dormList);
        return "dormManagement";
    }
    @RequestMapping("/addDorm")
    @ResponseBody
    public Map<String,Object> addBuild(@RequestBody Dorm dorm){
        dormService.insertOne(dorm);
        Map<String ,Object> map = new HashMap<>();
        return map;
    }
    @RequestMapping("/updateDorm")
    @ResponseBody
    public Map<String,Object> updateBuild(@RequestBody Dorm dorm){
        System.out.println(dorm);
        int i = dormService.updateOne(dorm);
        System.out.println(i);
        Map<String ,Object> map = new HashMap<>();
        map.put("message","修改成功");
        return map;
    }
    @RequestMapping("/deleteDorm")
    @ResponseBody
    private Map<String,Object> deleteById(@RequestBody Dorm dorm){
        dormService.deleteById(dorm.getDorId());
        Map<String,Object> map = new HashMap<>();
        map.put("message","删除成功");
        return map;
    }
}
