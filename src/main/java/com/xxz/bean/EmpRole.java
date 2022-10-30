package com.xxz.bean;

public class EmpRole {
    private String erId;
    private String eId;
    private String rId;

    public String getErId() {
        return erId;
    }

    public void setErId(String erId) {
        this.erId = erId;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public EmpRole(String erId, String eId, String rId) {
        this.erId = erId;
        this.eId = eId;
        this.rId = rId;
    }

    public EmpRole() {
    }

    @Override
    public String toString() {
        return "EmpRole{" +
                "erId='" + erId + '\'' +
                ", eId='" + eId + '\'' +
                ", rId='" + rId + '\'' +
                '}';
    }
}
