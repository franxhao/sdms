package com.hqyj.twelve.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 寝室楼POJO
 * 对应表building
 */
public class Building implements Serializable {
    private Integer buildId;
    private String buildName;
    private Integer romAmount;
    private Integer floorAmount;
    private Integer personAmount;

    private List<Dorm> dorms;

    public Building() {
    }

    public Building(Integer buildId, String buildName, Integer romAmount, Integer floorAmount, Integer personAmount, List<Dorm> dorms) {
        this.buildId = buildId;
        this.buildName = buildName;
        this.romAmount = romAmount;
        this.floorAmount = floorAmount;
        this.personAmount = personAmount;
        this.dorms = dorms;
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildId=" + buildId +
                ", buildName='" + buildName + '\'' +
                ", romAmount=" + romAmount +
                ", floorAmount=" + floorAmount +
                ", personAmount=" + personAmount +
                ", dorms=" + dorms +
                '}';
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public Integer getRomAmount() {
        return romAmount;
    }

    public void setRomAmount(Integer romAmount) {
        this.romAmount = romAmount;
    }

    public Integer getFloorAmount() {
        return floorAmount;
    }

    public void setFloorAmount(Integer floorAmount) {
        this.floorAmount = floorAmount;
    }

    public Integer getPersonAmount() {
        return personAmount;
    }

    public void setPersonAmount(Integer personAmount) {
        this.personAmount = personAmount;
    }

    public List<Dorm> getDorms() {
        return dorms;
    }

    public void setDorms(List<Dorm> dorms) {
        this.dorms = dorms;
    }
}
