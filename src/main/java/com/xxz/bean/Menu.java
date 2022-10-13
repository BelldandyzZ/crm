package com.xxz.bean;

public class Menu {
    private String  mId;
    private String  parentCode;
    private String  curCode;
    private String  mName;

    public Menu() {
    }

    @Override
    public String toString() {
        return "Menu{" +
                "mId='" + mId + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", curCode='" + curCode + '\'' +
                ", mName='" + mName + '\'' +
                '}';
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getCurCode() {
        return curCode;
    }

    public void setCurCode(String curCode) {
        this.curCode = curCode;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
