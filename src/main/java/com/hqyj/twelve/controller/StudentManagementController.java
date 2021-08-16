package com.hqyj.twelve.controller;

import com.hqyj.twelve.pojo.PageData;
import com.hqyj.twelve.pojo.Student;
import com.hqyj.twelve.service.StudentManagementService;
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
@RequestMapping("/stuManagement")
public class StudentManagementController {
    @Autowired
    private StudentManagementService studentManagementService;

    @RequestMapping("/findAll")
    public String getAllStu(Integer pageNumber, Integer pageSize, ModelMap modelMap){
        int number;
        int size;
        if (pageNumber == null) {
            number = 1; //默认显示第一页
        } else {
            number = pageNumber;
        }
        if (pageSize == null) {
            size = 5;   //默认每页显示5条
        } else {
            size = pageSize;
        }
        PageData<Student> students = studentManagementService.getStuManagementByPage(number, size);
//        List<Student> students = studentManagementService.findAll();
        modelMap.put("STUDENTS", students);
        return "studentManagement";
    }

    @RequestMapping("/addStu")
    @ResponseBody
    public String addStu(@RequestBody Map<String, Object> data){
        String message = studentManagementService.addStu(data);
        return message;
    }

    @RequestMapping("/search")
    public String searchVal(Map<String, Object> map){
        studentManagementService.searchVal(map);
        return null;
    }

    @RequestMapping("/reEdit")
    @ResponseBody
    public Student reEditMessage(@RequestBody Map<String, Object> keyAndName){
        return studentManagementService.reEditMessage(keyAndName);
    }

    @RequestMapping("/stuEdit")
    @ResponseBody
    public String stuEdit(@RequestBody Map<String, Object> editMassage){
        String flag = studentManagementService.stuEdit(editMassage);
        return flag;
    }

    @RequestMapping("/deleteOne")
    @ResponseBody
    public Map<String,Object> deleteOne(@RequestBody Map<String,Object> data){
        int flag = studentManagementService.removeByKeyAndName(data);
        Map<String, Object> map = new HashMap<>();
        if (flag == 3) {
            map.put("message","已入住状态暂时无法删除");
        } else if (flag > 0) {
            map.put("message","删除成功");
        } else {
            map.put("message", "删除失败");
        }
        return map;
    }
}
