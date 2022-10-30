package com.xxz.bean;

public class RoleMenu {
    private String rmId;
    private String mId;
    private String rId;

    @Override
    public String toString() {
        return "RoleMenu{" +
                "rmId='" + rmId + '\'' +
                ", mId='" + mId + '\'' +
                ", rId='" + rId + '\'' +
                '}';
    }

    public String getRmId() {
        return rmId;
    }

    public void setRmId(String rmId) {
        this.rmId = rmId;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public RoleMenu(String rmId, String mId, String rId) {
        this.rmId = rmId;
        this.mId = mId;
        this.rId = rId;
    }

    public RoleMenu() {
    }
}
