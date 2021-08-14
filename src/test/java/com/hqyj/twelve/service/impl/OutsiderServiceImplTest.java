package com.hqyj.twelve.service.impl;

import com.hqyj.twelve.pojo.Outsider;
import com.hqyj.twelve.service.OutsiderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class OutsiderServiceImplTest {
    @Autowired
    private OutsiderService outsiderService;

    @Test
    public void getAllOutsiderTest() {
        List<Outsider> allOutsider = outsiderService.getAllOutsider();
        for (Outsider outsider : allOutsider) {
            System.out.println(outsider);
        }
    }

    @Test
    public void getGoodsByNameAndPhoneTest() {
        List<Outsider> byNameAndPhone = outsiderService.getOutsiderByNameAndPhone("张三", "16698422965");
        for (Outsider outsider : byNameAndPhone) {
            System.out.println(outsider);
        }
    }

    @Test
    public void addOutsiderTest() {
        Outsider outsider = new Outsider();
        outsider.setOutName("朱八");
        outsider.setOutSex("男");
        outsider.setOutAge(30);
        String strDate = "2021-8-9";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTime;
        try {
            dateTime = simpleDateFormat.parse(strDate);
            java.sql.Date sqlTime = new java.sql.Date(dateTime.getTime());
            outsider.setRecordIn(sqlTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //outsider.setRecordIn(new Date());
        outsider.setRecordOut(null);
        outsider.setOutPhone("14729871098");
        outsider.setOutDes("探亲");
        int result = outsiderService.addOutsider(outsider);
        if (result > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    @Test
    public void modifyInformationTest() {
        Outsider outsider = new Outsider();
        outsider.setOutId(1);
        outsider.setOutPhone("16698422957");
        outsiderService.modifyInformation(outsider);
    }

    @Test
    public void removeByIdTest() {
        int result = outsiderService.removeById(9);
        if (result > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }
}