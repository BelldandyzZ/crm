package com.xxz.bean;

import java.io.Serializable;
import java.util.List;

public class Project implements Serializable {
    private Integer pId;

    private String pName;

    private String pMoeny;

    private String pProgress;

    private String pOwner;

    private Integer cpId;
    //业务设置列------------------------------------
    private String cIds;
    public String getcIds() { return cIds;}
    public void setcIds(String cIds) {this.cIds = cIds;}
    //----------------------------------------------
    //业务设置列------------------------------------
    private List<String> cRenames;
    public List<String> getcRenames() {return cRenames;}
    public void setcRenames(List<String> cRenames) {this.cRenames = cRenames;}
    //----------------------------------------------

    private String startTime;

    private String endTime;
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private Integer pbId;

    private Integer total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    private static final long serialVersionUID = 1L;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public String getpMoeny() {
        return pMoeny;
    }

    public void setpMoeny(String pMoeny) {
        this.pMoeny = pMoeny == null ? null : pMoeny.trim();
    }

    public String getpProgress() {
        return pProgress;
    }

    public void setpProgress(String pProgress) {
        this.pProgress = pProgress == null ? null : pProgress.trim();
    }

    public String getpOwner() {
        return pOwner;
    }

    public void setpOwner(String pOwner) {
        this.pOwner = pOwner == null ? null : pOwner.trim();
    }

    public Integer getCpId() {
        return cpId;
    }

    public void setCpId(Integer cpId) {
        this.cpId = cpId;
    }

    public Integer getPbId() {
        return pbId;
    }

    public void setPbId(Integer pbId) {
        this.pbId = pbId;
    }

    @Override
    public String toString() {
        return "Project{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pMoeny='" + pMoeny + '\'' +
                ", pProgress='" + pProgress + '\'' +
                ", pOwner='" + pOwner + '\'' +
                ", cpId=" + cpId +
                ", cIds='" + cIds + '\'' +
                ", cRenames=" + cRenames +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", pbId=" + pbId +
                ", total=" + total +
                '}';
    }
}