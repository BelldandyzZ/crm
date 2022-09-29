package com.xxz.bean;

import java.io.Serializable;

public class Customer implements Serializable {
    private Integer cId;

    private String cName;

    private String cDepart;

    private String cJob;

    private String cTele;

    private String cPost;

    private String cHobby;

    private String cRemark;

    private static final long serialVersionUID = 1L;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcDepart() {
        return cDepart;
    }

    public void setcDepart(String cDepart) {
        this.cDepart = cDepart == null ? null : cDepart.trim();
    }

    public String getcJob() {
        return cJob;
    }

    public void setcJob(String cJob) {
        this.cJob = cJob == null ? null : cJob.trim();
    }

    public String getcTele() {
        return cTele;
    }

    public void setcTele(String cTele) {
        this.cTele = cTele == null ? null : cTele.trim();
    }

    public String getcPost() {
        return cPost;
    }

    public void setcPost(String cPost) {
        this.cPost = cPost == null ? null : cPost.trim();
    }

    public String getcHobby() {
        return cHobby;
    }

    public void setcHobby(String cHobby) {
        this.cHobby = cHobby == null ? null : cHobby.trim();
    }

    public String getcRemark() {
        return cRemark;
    }

    public void setcRemark(String cRemark) {
        this.cRemark = cRemark == null ? null : cRemark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cId=").append(cId);
        sb.append(", cName=").append(cName);
        sb.append(", cDepart=").append(cDepart);
        sb.append(", cJob=").append(cJob);
        sb.append(", cTele=").append(cTele);
        sb.append(", cPost=").append(cPost);
        sb.append(", cHobby=").append(cHobby);
        sb.append(", cRemark=").append(cRemark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}