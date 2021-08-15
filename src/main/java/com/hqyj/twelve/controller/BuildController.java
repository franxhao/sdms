package com.hqyj.twelve.controller;

import com.hqyj.twelve.pojo.Building;
import com.hqyj.twelve.service.BuildService;
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
@RequestMapping("/building")
public class BuildController {
    @Autowired
    private BuildService buildService;
    @RequestMapping("/queryAllBuild")
    public String queryAllBuilding(ModelMap modelMap){
        List<Building> buildingList = buildService.queryAll();
        modelMap.addAttribute("buildingList",buildingList);
        return "buildManagement";
    }
    @RequestMapping("/addBuild")
    @ResponseBody
    public Map<String,Object> addBuild(@RequestBody Building building){
        buildService.insertOne(building);
        Map<String ,Object> map = new HashMap<>();
        return map;
    }
    @RequestMapping("/updateBuild")
    @ResponseBody
    public Map<String,Object> updateBuild(@RequestBody Building building){
        System.out.println(building);
        int i = buildService.updateOne(building);
        System.out.println(i);
        Map<String ,Object> map = new HashMap<>();
        map.put("message","修改成功");
        return map;
    }
    @RequestMapping("/deleteBuild")
    @ResponseBody
    private Map<String,Object> deleteById(@RequestBody Building building){
        buildService.deleteById(building.getBuildId());
        Map<String,Object> map = new HashMap<>();
        map.put("message","删除成功");
        return map;
    }

}
