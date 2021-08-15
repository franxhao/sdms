package com.hqyj.twelve.service;

import com.hqyj.twelve.pojo.Outsider;
import com.hqyj.twelve.pojo.PageData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OutsiderService {
    //查询所有人员来访信息
    List<Outsider> getAllOutsider();

    //根据 姓名和手机号码 查询个人来访信息
    List<Outsider> getOutsiderByNameAndPhone(String outName, String outPhone);

    //根据 id 查询 个人来访信息
    Outsider getOutsiderById(Integer outId);

    //添加来访人员信息
    int addOutsider(Outsider outsider);

    //修改 来访人员信息
    int modifyInformation(Outsider outsider);

    //删除来访人员信息
    int removeById(int outId);

    //获取单页的用户信息
    //pageNumber 页码     pageSize 每页记录数
    PageData<Outsider> getOutsiderByPage(int pageNumber, int pageSize);
}
