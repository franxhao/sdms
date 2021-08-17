package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Building;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class buildDaoTest {
    @Autowired
    private BuildDao buildDao;
    @Test
    public void queryAll() {
        List<Building> buildingList = buildDao.queryAll();
        for (Building buildings:buildingList){
            System.out.println(buildings);
        }
    }
    @Test
    public void updateOne() {
        Building build = new Building(13,"海棠苑2",200,5,2000,null);
        int rs = buildDao.updateOne(build);
        System.out.println("返回结果："+rs);
    }
    @Test
    public void insertOne() {
        Building build = new Building(0,"海棠苑2",100,4,1000,null);
        int rs = buildDao.insertOne(build);
        System.out.println("返回结果："+rs);
    }
    @Test
    public void deleteById(){
        int rs = buildDao.deleteById(10);
        System.out.println("返回结果："+rs);
    }
    @Test
    public void queryById(){
        System.out.println(buildDao.queryBuildById(3));
    }
}