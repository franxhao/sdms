package com.hqyj.twelve.dao;


import com.hqyj.twelve.pojo.Outsider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OutSiderDao {

    //查询所有人员来访信息
    List<Outsider> queryAllOutsider();

    //根据 姓名和手机号码 查询个人来访信息
    List<Outsider> queryOutsiderByNameAndPhone(@Param("name") String outName, @Param("phone") String outPhone);

    //添加 来访人员信息
    int insertOutsider(Outsider outsider);

    //修改 来访人员信息
    int updateOutsiderById(Outsider outsider);

    //删除 来访人员信息
    int deleteById(int outId);

}
