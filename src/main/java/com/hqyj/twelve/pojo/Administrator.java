package com.hqyj.twelve.pojo;

import java.io.Serializable;

/**
 * 管理员POJO
 * 对应表administrator
 */
public class Administrator implements Serializable {
    private Integer adId;
    private String adUsername;
    private String adPassword;
    private String adName;
    private String adSex;
    private Integer adAge;
    private String adJob;
    private String adPhone;
    private String adAddress;
    private Integer roleId;
    private String adDes;

    @Override
    public String toString() {
        return "Administrator{" +
                "adId=" + adId +
                ", adUsername='" + adUsername + '\'' +
                ", adPassword='" + adPassword + '\'' +
                ", adName='" + adName + '\'' +
                ", adSex='" + adSex + '\'' +
                ", adAge=" + adAge +
                ", adJob='" + adJob + '\'' +
                ", adPhone=" + adPhone +
                ", adAddress='" + adAddress + '\'' +
                ", roleId=" + roleId +
                ", adDes='" + adDes + '\'' +
                '}';
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public String getAdUsername() {
        return adUsername;
    }

    public void setAdUsername(String adUsername) {
        this.adUsername = adUsername;
    }

    public String getAdPassword() {
        return adPassword;
    }

    public void setAdPassword(String adPassword) {
        this.adPassword = adPassword;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdSex() {
        return adSex;
    }

    public void setAdSex(String adSex) {
        this.adSex = adSex;
    }

    public Integer getAdAge() {
        return adAge;
    }

    public void setAdAge(Integer adAge) {
        this.adAge = adAge;
    }

    public String getAdJob() {
        return adJob;
    }

    public void setAdJob(String adJob) {
        this.adJob = adJob;
    }

    public String getAdPhone() {
        return adPhone;
    }

    public void setAdPhone(String adPhone) {
        this.adPhone = adPhone;
    }

    public String getAdAddress() {
        return adAddress;
    }

    public void setAdAddress(String adAddress) {
        this.adAddress = adAddress;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getAdDes() {
        return adDes;
    }

    public void setAdDes(String adDes) {
        this.adDes = adDes;
    }
}
