package com.hqyj.twelve.controller;

import com.hqyj.twelve.pojo.Student;
import com.hqyj.twelve.service.StudentManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/stuManagement")
public class StudentManagementController {
    @Autowired
    private StudentManagementService studentManagementService;

    @RequestMapping("/findAll")
    public String getAllStu(ModelMap modelMap){
        List<Student> students = studentManagementService.findAll();
        modelMap.addAttribute("STUDENTS", students);
        return "studentManagement";
    }

    @RequestMapping("/addStu")
    @ResponseBody
    public String addStu(@RequestBody Map<String, Object> data){
        String message = studentManagementService.addStu(data);
        return message;
    }
}
