package com.hqyj.twelve.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 外来人员POJO
 * 对应表outsider（外来人员访问登记表）
 */
public class Outsider implements Serializable {
    private Integer outId;
    private String outName;
    private String outSex;
    private Integer outAge;
    private Date recordIn;
    private Date recordOut;
    private Integer outPhone;
    private String outDes;

    @Override
    public String toString() {
        return "Outsider{" +
                "outId=" + outId +
                ", outName='" + outName + '\'' +
                ", outSex='" + outSex + '\'' +
                ", outAge=" + outAge +
                ", recordIn=" + recordIn +
                ", recordOut=" + recordOut +
                ", outPhone=" + outPhone +
                ", outDes='" + outDes + '\'' +
                '}';
    }

    public Integer getOutId() {
        return outId;
    }

    public void setOutId(Integer outId) {
        this.outId = outId;
    }

    public String getOutName() {
        return outName;
    }

    public void setOutName(String outName) {
        this.outName = outName;
    }

    public String getOutSex() {
        return outSex;
    }

    public void setOutSex(String outSex) {
        this.outSex = outSex;
    }

    public Integer getOutAge() {
        return outAge;
    }

    public void setOutAge(Integer outAge) {
        this.outAge = outAge;
    }

    public Date getRecordIn() {
        return recordIn;
    }

    public void setRecordIn(Date recordIn) {
        this.recordIn = recordIn;
    }

    public Date getRecordOut() {
        return recordOut;
    }

    public void setRecordOut(Date recordOut) {
        this.recordOut = recordOut;
    }

    public Integer getOutPhone() {
        return outPhone;
    }

    public void setOutPhone(Integer outPhone) {
        this.outPhone = outPhone;
    }

    public String getOutDes() {
        return outDes;
    }

    public void setOutDes(String outDes) {
        this.outDes = outDes;
    }
}
