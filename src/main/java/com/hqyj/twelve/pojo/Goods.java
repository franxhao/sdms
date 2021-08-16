package com.hqyj.twelve.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 物品POJO
 * 对应表goods（物品暂存出入登记表）
 */
public class Goods implements Serializable {
    private Integer goodsId;
    private String goodsName;
    private String goodsPerson;
    private String personPhone;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date goodsIn;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date goodsOut;
    private String goodsDes;

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPerson='" + goodsPerson + '\'' +
                ", personPhone=" + personPhone +
                ", goodsIn=" + goodsIn +
                ", goodsOut=" + goodsOut +
                ", goodsDes='" + goodsDes + '\'' +
                '}';
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPerson() {
        return goodsPerson;
    }

    public void setGoodsPerson(String goodsPerson) {
        this.goodsPerson = goodsPerson;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public Date getGoodsIn() {
        return goodsIn;
    }

    public void setGoodsIn(Date goodsIn) {
        this.goodsIn = goodsIn;
    }

    public Date getGoodsOut() {
        return goodsOut;
    }

    public void setGoodsOut(Date goodsOut) {
        this.goodsOut = goodsOut;
    }

    public String getGoodsDes() {
        return goodsDes;
    }

    public void setGoodsDes(String goodsDes) {
        this.goodsDes = goodsDes;
    }
}
