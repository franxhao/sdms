package com.hqyj.twelve.service;

import com.hqyj.twelve.pojo.Outsider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OutsiderService {
    //查询所有人员来访信息
    List<Outsider> getAllOutsider();

    //根据 姓名和手机号码 查询个人来访信息
    List<Outsider> getGoodsByNameAndPhone(String outName, String outPhone);

    int addOutsider(Outsider outsider);
}
