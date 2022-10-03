package com.xxz.bean;

import java.io.Serializable;

public class Project implements Serializable {
    private Integer pId;

    private String pName;

    private String pMoeny;

    private String pProgress;

    private String pOwner;

    private Integer cpId;

    private Integer pbId;

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
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pId=").append(pId);
        sb.append(", pName=").append(pName);
        sb.append(", pMoeny=").append(pMoeny);
        sb.append(", pProgress=").append(pProgress);
        sb.append(", pOwner=").append(pOwner);
        sb.append(", cpId=").append(cpId);
        sb.append(", pbId=").append(pbId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}