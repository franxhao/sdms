package com.hqyj.twelve.service.impl;

import com.hqyj.twelve.pojo.Building;
import com.hqyj.twelve.service.BuildService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class BuildServiceImplTest {
    @Autowired
    private BuildService buildService;
    @Test
    public void queryAll() {
        List<Building> buildingList = buildService.queryAll();
        for (Building buildings:buildingList){
            System.out.println(buildings);
        }
    }

    @Test
    public void updateOne() {
    }

    @Test
    public void insertOne() {
    }

    @Test
    public void deleteById() {
    }
}