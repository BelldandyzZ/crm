package com.xxz.bean;

import java.io.Serializable;

public class Interview implements Serializable {
    private Integer iId;

    private String iCompany;

    private Integer cId;

    private String iVisitTime;

    private Integer pId;

    private Integer eId;

    private String iOthers;

    private String iContent;

    private String iNext;

    private static final long serialVersionUID = 1L;

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public String getiCompany() {
        return iCompany;
    }

    public void setiCompany(String iCompany) {
        this.iCompany = iCompany == null ? null : iCompany.trim();
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getiVisitTime() {
        return iVisitTime;
    }

    public void setiVisitTime(String iVisitTime) {
        this.iVisitTime = iVisitTime == null ? null : iVisitTime.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String getiOthers() {
        return iOthers;
    }

    public void setiOthers(String iOthers) {
        this.iOthers = iOthers == null ? null : iOthers.trim();
    }

    public String getiContent() {
        return iContent;
    }

    public void setiContent(String iContent) {
        this.iContent = iContent == null ? null : iContent.trim();
    }

    public String getiNext() {
        return iNext;
    }

    public void setiNext(String iNext) {
        this.iNext = iNext == null ? null : iNext.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", iId=").append(iId);
        sb.append(", iCompany=").append(iCompany);
        sb.append(", cId=").append(cId);
        sb.append(", iVisitTime=").append(iVisitTime);
        sb.append(", pId=").append(pId);
        sb.append(", eId=").append(eId);
        sb.append(", iOthers=").append(iOthers);
        sb.append(", iContent=").append(iContent);
        sb.append(", iNext=").append(iNext);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}