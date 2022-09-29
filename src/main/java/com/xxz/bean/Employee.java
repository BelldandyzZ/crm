package com.xxz.bean;

import java.io.Serializable;

public class Employee implements Serializable {
    private Integer eId;

    private String rename;

    private String eName;

    private String ePwd;

    private String eBirthday;

    private String eSchool;

    private String eJob;

    private String eStartTime;

    private String eSocialPosition;

    private String eHonor;

    private String eRemark;

    private static final long serialVersionUID = 1L;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String getRename() {
        return rename;
    }

    public void setRename(String rename) {
        this.rename = rename == null ? null : rename.trim();
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    public String getePwd() {
        return ePwd;
    }

    public void setePwd(String ePwd) {
        this.ePwd = ePwd == null ? null : ePwd.trim();
    }

    public String geteBirthday() {
        return eBirthday;
    }

    public void seteBirthday(String eBirthday) {
        this.eBirthday = eBirthday == null ? null : eBirthday.trim();
    }

    public String geteSchool() {
        return eSchool;
    }

    public void seteSchool(String eSchool) {
        this.eSchool = eSchool == null ? null : eSchool.trim();
    }

    public String geteJob() {
        return eJob;
    }

    public void seteJob(String eJob) {
        this.eJob = eJob == null ? null : eJob.trim();
    }

    public String geteStartTime() {
        return eStartTime;
    }

    public void seteStartTime(String eStartTime) {
        this.eStartTime = eStartTime == null ? null : eStartTime.trim();
    }

    public String geteSocialPosition() {
        return eSocialPosition;
    }

    public void seteSocialPosition(String eSocialPosition) {
        this.eSocialPosition = eSocialPosition == null ? null : eSocialPosition.trim();
    }

    public String geteHonor() {
        return eHonor;
    }

    public void seteHonor(String eHonor) {
        this.eHonor = eHonor == null ? null : eHonor.trim();
    }

    public String geteRemark() {
        return eRemark;
    }

    public void seteRemark(String eRemark) {
        this.eRemark = eRemark == null ? null : eRemark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eId=").append(eId);
        sb.append(", rename=").append(rename);
        sb.append(", eName=").append(eName);
        sb.append(", ePwd=").append(ePwd);
        sb.append(", eBirthday=").append(eBirthday);
        sb.append(", eSchool=").append(eSchool);
        sb.append(", eJob=").append(eJob);
        sb.append(", eStartTime=").append(eStartTime);
        sb.append(", eSocialPosition=").append(eSocialPosition);
        sb.append(", eHonor=").append(eHonor);
        sb.append(", eRemark=").append(eRemark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}