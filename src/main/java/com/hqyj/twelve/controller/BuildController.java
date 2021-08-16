package com.hqyj.twelve.controller;

import com.hqyj.twelve.pojo.Building;
import com.hqyj.twelve.pojo.Outsider;
import com.hqyj.twelve.pojo.PageData;
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
    public String queryAllBuilding(Integer pageNumber, Integer pageSize,ModelMap modelMap){
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
        PageData<Building> pageData = buildService.getBuildByPage(number, size);
        modelMap.put("pageData", pageData);
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
    public Map<String,Object> queryBuildById(@RequestBody Building building){
        int buildId=building.getBuildId();
        Building build = buildService.queryBuildById(buildId);
        Map<String,Object> map = new HashMap<>();
        map.put("build",build);
        return map;
    }
    @RequestMapping("/updateBuildDo")
    @ResponseBody
    public Map<String,Object> updateBuild(@RequestBody Building building){

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
