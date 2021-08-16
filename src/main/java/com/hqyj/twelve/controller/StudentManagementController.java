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

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/stuManagement")
public class StudentManagementController {
    @Autowired
    private StudentManagementService studentManagementService;

    /**
     * 查询所有学生的信息
     * @param modelMap
     * @return
     */
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
        PageData<Student> students = studentManagementService.getOutsiderByPage(number, size);
//        List<Student> students = studentManagementService.findAll();
        modelMap.addAttribute("STUDENTS", students);
        return "studentManagement";
    }

    /**
     * 添加学生信息
     * @param data
     * @return
     */
    @RequestMapping("/addStu")
    @ResponseBody
    public String addStu(@RequestBody Map<String, Object> data){
        String message = studentManagementService.addStu(data);
        return message;
    }

    /**
     * 搜索功能
     * @param map
     * @return
     */
    @RequestMapping("/search")
    public String searchVal(Map<String, Object> map){
        studentManagementService.searchVal(map);
        return null;
    }

    /**
     * 修改学生信息之回传数据
     * @param keyAndName
     * @return
     */
    @RequestMapping("/reEdit")
    @ResponseBody
    public List<Student> reEditMessage(@RequestBody Map<String, Object> keyAndName){
        return studentManagementService.reEditMessage(keyAndName);
    }

    @RequestMapping("/stuEdit")
    @ResponseBody
    public String stuEdit(@RequestBody Map<String, Object> editMassage){
        String flag = studentManagementService.stuEdit(editMassage);
        return flag;
    }
}
