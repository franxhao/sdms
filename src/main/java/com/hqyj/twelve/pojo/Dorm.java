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
    private BigDecimal dorPrice;  //住宿费用

    private List<Student> students;

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

    public BigDecimal getDorPrice() {
        return dorPrice;
    }

    public void setDorPrice(BigDecimal dorPrice) {
        this.dorPrice = dorPrice;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
