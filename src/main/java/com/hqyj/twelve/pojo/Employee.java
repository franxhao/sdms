package com.hqyj.twelve.pojo;

import java.io.Serializable;

/**
 * 员工（宿管）POJO
 * 对应表employee
 */
public class Employee implements Serializable {
    private Integer empId;
    private String empUsername;
    private String empPassword;
    private String empName;
    private String empSex;
    private Integer empAge;
    private String empJob;
    private Integer empPhone;
    private String empAddress;
    private Integer roleId;
    private String buildId;
    private String empDes;

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empUsername='" + empUsername + '\'' +
                ", empPassword='" + empPassword + '\'' +
                ", empName='" + empName + '\'' +
                ", empSex='" + empSex + '\'' +
                ", empAge=" + empAge +
                ", empJob='" + empJob + '\'' +
                ", empPhone=" + empPhone +
                ", empAddress='" + empAddress + '\'' +
                ", roleId=" + roleId +
                ", buildId='" + buildId + '\'' +
                ", empDes='" + empDes + '\'' +
                '}';
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpUsername() {
        return empUsername;
    }

    public void setEmpUsername(String empUsername) {
        this.empUsername = empUsername;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public String getEmpJob() {
        return empJob;
    }

    public void setEmpJob(String empJob) {
        this.empJob = empJob;
    }

    public Integer getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(Integer empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getBuildId() {
        return buildId;
    }

    public void setBuildId(String buildId) {
        this.buildId = buildId;
    }

    public String getEmpDes() {
        return empDes;
    }

    public void setEmpDes(String empDes) {
        this.empDes = empDes;
    }
}
