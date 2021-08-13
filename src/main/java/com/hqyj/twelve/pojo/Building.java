package com.hqyj.twelve.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 寝室楼POJO
 * 对应表building
 */
public class Building implements Serializable {
    private int buildId;
    private String buildName;
    private int romAmount;
    private int floorAmount;
    private int personAmount;

    private List<Dorm> dorms;

    public Building() {
    }

    public Building(int buildId, String buildName, int romAmount, int floorAmount, int personAmount, List<Dorm> dorms) {
        this.buildId = buildId;
        this.buildName = buildName;
        this.romAmount = romAmount;
        this.floorAmount = floorAmount;
        this.personAmount = personAmount;
        this.dorms = dorms;
    }

    public int getBuildId() {
        return buildId;
    }

    public void setBuildId(int buildId) {
        this.buildId = buildId;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public int getRomAmount() {
        return romAmount;
    }

    public void setRomAmount(int romAmount) {
        this.romAmount = romAmount;
    }

    public int getFloorAmount() {
        return floorAmount;
    }

    public void setFloorAmount(int floorAmount) {
        this.floorAmount = floorAmount;
    }

    public int getPersonAmount() {
        return personAmount;
    }

    public void setPersonAmount(int personAmount) {
        this.personAmount = personAmount;
    }

    public List<Dorm> getDorms() {
        return dorms;
    }

    public void setDorms(List<Dorm> dorms) {
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
}
