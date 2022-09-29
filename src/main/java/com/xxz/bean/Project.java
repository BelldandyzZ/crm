package com.xxz.bean;

import java.io.Serializable;

public class Project implements Serializable {
    private Integer pId;

    private String pName;

    private String pMoeny;

    private String pProgress;

    private Integer cpId;

    private Integer ctId;

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

    public Integer getCpId() {
        return cpId;
    }

    public void setCpId(Integer cpId) {
        this.cpId = cpId;
    }

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pId=").append(pId);
        sb.append(", pName=").append(pName);
        sb.append(", pMoeny=").append(pMoeny);
        sb.append(", pProgress=").append(pProgress);
        sb.append(", cpId=").append(cpId);
        sb.append(", ctId=").append(ctId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}