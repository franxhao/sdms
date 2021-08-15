package com.hqyj.twelve.controller;

import com.hqyj.twelve.dao.OutSiderDao;
import com.hqyj.twelve.pojo.Administrator;
import com.hqyj.twelve.pojo.Outsider;
import com.hqyj.twelve.pojo.PageData;
import com.hqyj.twelve.service.OutsiderService;
import com.hqyj.twelve.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/outsider")
public class OutsiderController {
    @Autowired
    private OutsiderService outsiderService;

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
        PageData<Outsider> pageData = outsiderService.getOutsiderByPage(number, size);
        modelMap.put("pageData", pageData);
        return "outsider";
    }

    @RequestMapping("/addOutsider")
    @ResponseBody
    public Map<String, Object> addOutsider(@RequestBody Outsider outsider) {
        Date recordIn = outsider.getRecordIn();
        outsiderService.addOutsider(outsider);
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    @RequestMapping("/updateOutsider")
    @ResponseBody
    public Map<String,Object> updateOutsider(@RequestBody Outsider outsider){
        Integer outId = outsider.getOutId();
        Outsider outsiderById = outsiderService.getOutsiderById(outId);
        Map<String,Object> map = new HashMap<>();
        map.put("outsider",outsiderById);
        return map;
    }

    @RequestMapping("/updateOutsiderDo")
    @ResponseBody
    public Map<String,Object> updateOutsiderDo(@RequestBody Outsider outsider){
        System.out.println(outsider);
        int i = outsiderService.modifyInformation(outsider);
        System.out.println(i);
        Map<String,Object> map = new HashMap<>();
        map.put("message","修改成功");
        return map;
    }
}
