package com.hqyj.twelve.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.twelve.dao.BuildDao;
import com.hqyj.twelve.dao.DormDao;
import com.hqyj.twelve.dao.StudentDao;
import com.hqyj.twelve.pojo.Building;
import com.hqyj.twelve.pojo.Dorm;
import com.hqyj.twelve.pojo.PageData;
import com.hqyj.twelve.pojo.Student;
import com.hqyj.twelve.service.StudentManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class StudentManagementServiceImpl implements StudentManagementService {
    @Autowired
    public StudentDao studentDao;

    @Autowired
    public DormDao dormDao;

    @Autowired
    public BuildDao buildDao;

    @Override
    public List<Student> findAll() {
        //查所有学生信息
        List<Student> all = studentDao.findAll();
        //通过学生id查询学生寝室表
       /* for (Student student : all) {
            Integer stuId = student.getStuId();
            Map<String, Object> map = studentDao.queryStuDorByStuId(stuId);
            //获得学生寝室id,并通过寝室号查询楼房表
            for (String s : map.keySet()) {
                if ("dor_id".equals(map.get(s))) {
                    Integer dorId = (Integer) map.get(s);
                    Map<String, Object> buildDorm = buildDao.queryBDByDorId(dorId);
                    //通过楼房表查所在楼,得到楼名
                    Integer buildId = (Integer) buildDorm.get("build_id");
                    Building building = buildDao.queryBuildingById(buildId);
                    String buildName = building.getBuildName();
                    //拼接出寝室名称，并填回list集合中
                    // 楼房名buildName + "房间" + dorId
                    String room = buildName + "房间" + dorId;
                    student.setRoom(room);
                }
            }
        }*/
        return all;
    }

    @Override
    public String addStu(Map<String, Object> data) {
        //1.将入学日期和出生日期的字符串类型转换为时间格式
        //stuEnr:$("#stuEnr").val()
        //stuBirthday:$("#stuBirthday").val()
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date enr = simpleDateFormat.parse((String) data.get("stuEnr"));
            Date birthday = simpleDateFormat.parse((String) data.get("stuBirth"));
            data.put("stuEnr",enr);
            data.put("stuBirth",birthday);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //2.添加学生信息
            //2.1通过查询学生学号和姓名，判断该学生是否已经在库中，不在则添加，在则不添加
        String stuKey = (String) data.get("stuKey");
        String stuName = (String) data.get("stuName");
        Student student = studentDao.queryStuByKeyAndName(stuKey, stuName);
        if (student == null) {
            //无此学生，可以添加
            boolean result = studentDao.addStu(data);
            if (result) {
                // 返回ok，表示添加成功
                return "ok";
            } else {
                //添加失败，返回fail,表示添加失败
                return "fail";
            }
        } else {
            //有此学生，返回exist，表示已存在
            return "exist";
        }
    }

    @Override
    public void searchVal(Map<String, Object> map) {
        //1.获取用户所选的搜索条件
        String[] sel = (String[]) map.get("sel");
        for (int i = 0; i < sel.length; i++) {
            if (sel[i].equals("sel1")) {
                String op1 = "sel1";
            } else if (sel[i].equals("sel2")) {
                String op2 = "sel2";
            } else if (sel[i].equals("sel3")) {
                String op3 = "sel3";
            } else if (sel[i].equals("sel4")) {
                String op4 = "sel4";
            } else if (sel[i].equals("sel5")) {
                String op5 = "sel5";
            }
        }
        //2.获取用户搜索框输入的值
        String search = (String) map.get("search_val");
        //3.调用DAO层方法，做模糊查询
        //studentDao.searchSth();
        //4.返回学生类型
    }

    @Override
    public Student reEditMessage(Map<String, Object> keyAndName) {
        //获取学号和姓名
        String stuKey = (String) keyAndName.get("key");
        String stuName = (String) keyAndName.get("name");

        //通过学号和姓名查询学生信息
        Student student = studentDao.queryStuByKeyAndName(stuKey, stuName);

        //将学生信息返回给控制器
        return student;
    }

    @Override
    public String stuEdit(Map<String, Object> editMassage) {
        boolean flag = studentDao.UpdateStuMassage(editMassage);
        if (flag) {
            //修改成功，返回ok
            return "ok";
        }else {
            //修改失败，返回fail
            return "fail";
        }
    }

    @Override
    public PageData<Student> getStuManagementByPage(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Student> students = studentDao.findAll();
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        PageData<Student> pageData = new PageData<>();

        pageData.setCurrentPage(pageNumber);
        pageData.setPageSize(pageSize);
        pageData.setTotalPage(pageInfo.getPages());
        pageData.setTotalSize((int) pageInfo.getTotal());
        if (pageInfo.isHasNextPage()) {
            pageData.setNextPage(pageInfo.getNextPage());
        } else {
            pageData.setNextPage(pageInfo.getPages());
        }
        if (pageInfo.isHasPreviousPage()) {
            pageData.setPreviousPage(pageInfo.getPrePage());
        } else {
            pageData.setPreviousPage(1);
        }
        pageData.setList(pageInfo.getList());
        return pageData;
    }

    @Override
    public int removeByKeyAndName(Map<String, Object> data) {
        String stuKey = (String) data.get("key");
        String stuName = (String) data.get("name");
        //1、查询学生信息，获取学生记录的id，住宿状态
        Student student = studentDao.queryStuByKeyAndName(stuKey, stuName);
        Integer stuId = student.getStuId();
        String stuState = student.getStuState();

        //2、如果住宿状态为已入住，则查学生寝室表，获取表id和学生的寝室id；如果为未入住，直接删除学生信息
        if ("已入住".equals(stuState)) {
            /*int i = studentDao.queryStuDorByStuId(stuId);
            Integer id = (Integer) map.get("id");
            Integer dorId = (Integer) map.get("dor_id");

            //1.已入住学生，先删除学生寝室表的记录，再删除学生信息
            studentDao.deleteStuDorById(id);
            studentDao.deleteOneById(stuId);
            //2.查该学生所住寝室的信息，并获取实住人数
            Dorm dorm = studentDao.queryDormById(dorId);
            Integer dorFact = dorm.getDorFact();
            //3.实住人数-1
            if (dorFact > 0) {
                dorFact -= 1;
                dorm.setDorFact(dorFact);
                //3.更新寝室实住人数
                dormDao.updateOne(dorm);
            }*/
            //返回1，删除完成
            //返回3，已入住暂时无法删除
            return 3;
        } else if ("未入住".equals(stuState)) {
            studentDao.deleteOneByKeyAndName(stuKey, stuName);
            //返回1，表删除成功
            return 1;
        } else {
            //出错
            return -1;
        }
    }

    @Override
    public void addStuforStudent(Student student) {
        studentDao.addStuforStudent(student);
    }

    @Override
    public List<Student> queryLike(String inputVal) {
        return studentDao.queryLike(inputVal);
    }
}
