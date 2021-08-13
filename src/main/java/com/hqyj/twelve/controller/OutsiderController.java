package com.hqyj.twelve.controller;

import com.hqyj.twelve.dao.OutSiderDao;
import com.hqyj.twelve.pojo.Outsider;
import com.hqyj.twelve.pojo.PageData;
import com.hqyj.twelve.service.OutsiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
            size = 2;   //默认每页显示两条
        } else {
            size = pageSize;
        }
        PageData<Outsider> pageData = outsiderService.getOutsiderByPage(number, size);
        modelMap.put("pageData", pageData);
        return "outsider";
    }
}
