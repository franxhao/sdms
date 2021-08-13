package com.hqyj.twelve.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 寝室POJO
 * 对应表dorm（寝室房间信息）
 */
public class Dorm implements Serializable {
    private Integer dorId;
    private String dorSex;  //居住性别
    private Integer dorNum;  //应住人数
    private Integer dorFact;  //实住人数
    private double dorPrice;  //住宿费用

    private List<Student> students;

    public Dorm() {
    }

    public Dorm(Integer dorId, String dorSex, Integer dorNum, Integer dorFact, double dorPrice, List<Student> students) {
        this.dorId = dorId;
        this.dorSex = dorSex;
        this.dorNum = dorNum;
        this.dorFact = dorFact;
        this.dorPrice = dorPrice;
        this.students = students;
    }


    @Override
    public String toString() {
        return "Dorm{" +
                "dorId=" + dorId +
                ", dorSex='" + dorSex + '\'' +
                ", dorNum=" + dorNum +
                ", dorFact=" + dorFact +
                ", dorPrice=" + dorPrice +
                ", students=" + students +
                '}';
    }

    public Integer getDorId() {
        return dorId;
    }

    public void setDorId(Integer dorId) {
        this.dorId = dorId;
    }

    public String getDorSex() {
        return dorSex;
    }

    public void setDorSex(String dorSex) {
        this.dorSex = dorSex;
    }

    public Integer getDorNum() {
        return dorNum;
    }

    public void setDorNum(Integer dorNum) {
        this.dorNum = dorNum;
    }

    public Integer getDorFact() {
        return dorFact;
    }

    public void setDorFact(Integer dorFact) {
        this.dorFact = dorFact;
    }

    public double getDorPrice() {
        return dorPrice;
    }

    public void setDorPrice(double dorPrice) {
        this.dorPrice = dorPrice;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
