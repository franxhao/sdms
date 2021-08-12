package com.hqyj.twelve.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生POJO
 * 对应表student（学生信息）
 */
public class Student implements Serializable {
    private Integer stuId;
    private String stuKey;
    private String stuName;
    private String stuSex;
    private Date stuEnr;
    private Date stuBirth;
    private String stuCollege;
    private String stuMajor;
    private String stuClass;
    private String stuAddress;
    private String stuTel;
    private String stuState;
    private String stuDes;

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuKey='" + stuKey + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuEnr=" + stuEnr +
                ", stuBirth=" + stuBirth +
                ", stuCollege='" + stuCollege + '\'' +
                ", stuMajor='" + stuMajor + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", stuAddress='" + stuAddress + '\'' +
                ", stuTel=" + stuTel +
                ", stuState='" + stuState + '\'' +
                ", stuDes='" + stuDes + '\'' +
                '}';
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuKey() {
        return stuKey;
    }

    public void setStuKey(String stuKey) {
        this.stuKey = stuKey;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public Date getStuEnr() {
        return stuEnr;
    }

    public void setStuEnr(Date stuEnr) {
        this.stuEnr = stuEnr;
    }

    public Date getStuBirth() {
        return stuBirth;
    }

    public void setStuBirth(Date stuBirth) {
        this.stuBirth = stuBirth;
    }

    public String getStuCollege() {
        return stuCollege;
    }

    public void setStuCollege(String stuCollege) {
        this.stuCollege = stuCollege;
    }

    public String getStuMajor() {
        return stuMajor;
    }

    public void setStuMajor(String stuMajor) {
        this.stuMajor = stuMajor;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    public String getStuTel() {
        return stuTel;
    }

    public void setStuTel(String stuTel) {
        this.stuTel = stuTel;
    }

    public String getStuState() {
        return stuState;
    }

    public void setStuState(String stuState) {
        this.stuState = stuState;
    }

    public String getStuDes() {
        return stuDes;
    }

    public void setStuDes(String stuDes) {
        this.stuDes = stuDes;
    }
}
