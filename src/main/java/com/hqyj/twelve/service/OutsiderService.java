package com.hqyj.twelve.service;

import com.hqyj.twelve.pojo.Outsider;
import com.hqyj.twelve.pojo.PageData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OutsiderService {
    //查询所有人员来访信息
    List<Outsider> getAllOutsider();

    //根据 姓名和手机号码 查询个人来访信息
    List<Outsider> getGoodsByNameAndPhone(String outName, String outPhone);

    //添加来访人员信息
    int addOutsider(Outsider outsider);

    //获取单页的用户信息
    //pageNumber 页码     pageSize 每页记录数
    PageData<Outsider> getOutsiderByPage(int pageNumber, int pageSize);
}
