package com.xxz.bean;

public class Role {
    private String rId;
    private String rName;
    private String rRemark;

    public Role() {
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrRemark() {
        return rRemark;
    }

    public void setrRemark(String rRemark) {
        this.rRemark = rRemark;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rId='" + rId + '\'' +
                ", rName='" + rName + '\'' +
                ", rRemark='" + rRemark + '\'' +
                '}';
    }


}
